package com.api.APIRest.controllers;

import com.api.APIRest.dtos.AutenticacaoDados;
import com.api.APIRest.infra.security.DadosTokenJWT;
import com.api.APIRest.infra.security.TokenService;
import com.api.APIRest.models.Usuario;
import com.api.APIRest.repositorys.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid AutenticacaoDados dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.password());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
    @PostMapping(value = "/cadastrar")
    public ResponseEntity cadastrarusuario(@RequestBody @Valid Usuario user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usuarioRepository.save(user);
        return ResponseEntity.ok().body(user);
    }

}

