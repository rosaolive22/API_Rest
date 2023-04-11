package com.api.APIRest.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableMethodSecurity(securedEnabled = true)
@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeHttpRequests()

                .requestMatchers(HttpMethod.POST, "/login").permitAll()//se vier requizição libere pq é pública
                //Acrescentar todos os usuários depois alterar, somento adm pode acrescentar usuários novos
                .requestMatchers(HttpMethod.POST,"/login/cadastrar").permitAll()//.hasrole(ADMINISTRADOR)

                .requestMatchers(HttpMethod.GET, "/product/**").hasAnyRole("ADMINISTRADOR","COLABORADOR")
                .requestMatchers(HttpMethod.GET, "/catalog/**").hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.GET, "/company/**").hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.GET, "/image/**").hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.GET, "/order/**").hasRole("ADMINISTRADOR")

                .requestMatchers(HttpMethod.POST, "/product").hasAnyRole("ADMINISTRADOR","COLABORADOR")

                .requestMatchers(HttpMethod.DELETE, "/product/**").hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.DELETE, "/catalog/**").hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.DELETE, "/company/**").hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.DELETE, "/image/**").hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.DELETE, "/order/**").hasRole("ADMINISTRADOR")

                .requestMatchers(HttpMethod.PUT, "/product/**").hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.PUT, "/catalog/**").hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.PUT, "/company/**").hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.PUT, "/image/**").hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.PUT, "/order/**").hasRole("ADMINISTRADOR")

                .anyRequest().authenticated()//as outras apenas se estiver autenticado
                .and().addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    //started without this part
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
    //Configuramos o Sprig a usar hashing de senhas  (algoritmo BCrypt).
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
