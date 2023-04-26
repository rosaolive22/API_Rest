package com.api.APIRest.controllers;

import com.api.APIRest.dtos.AutenticacaoDados;
import com.api.APIRest.dtos.DetalhesUserDTO;
import com.api.APIRest.infra.security.DadosTokenJWT;
import com.api.APIRest.infra.security.TokenService;
import com.api.APIRest.models.Usuario;
import com.api.APIRest.repositorys.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Tag;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
//@Tag()
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
    @Operation(summary = "Efetuar Login de acesso ao usuário já cadastrado.")
    public ResponseEntity efetuarLogin(@RequestBody @Valid AutenticacaoDados dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.password());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
    @PostMapping(value = "/cadastrar")
    @Operation(summary = "Cadastrar novo usuário.")
    public ResponseEntity cadastrarusuario(@RequestBody @Valid Usuario user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usuarioRepository.save(user);
        return ResponseEntity.ok().body(user);
    }
    @GetMapping
    @Operation(summary = "Fornece lista de usuários cadastrados.")
    public ResponseEntity<?> listar(@PageableDefault Pageable paginacao){
        var page = usuarioRepository.findAll(paginacao);
        if (page.isEmpty()){
            return ResponseEntity.badRequest().body("Lista vazia.");
        }
        return ResponseEntity.ok(page);
    }
   /* @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<?> update(@RequestBody @Valid DetalhesUserDTO dados, @PathVariable Long id){
        var usuario = usuarioRepository.findById(id).orElse(null);
        assert usuario != null;
        usuario.update(dados);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok().body(usuario);
    }*/
    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Excluir usuário identificando seu id.")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id){
        //Excluir definitivamente:
        usuarioRepository.deleteById(id);
        ObjectMapper mapper = new ObjectMapper();
        Usuario usuarioAtivo = new Usuario();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    @Operation(summary = "Detalhar informações sobre usuário passando seu id.")
    public ResponseEntity detalhar(@PathVariable Long id){
        var usuario  = usuarioRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesUserDTO(usuario));
    }

}

