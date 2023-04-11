package com.api.APIRest.models;

import com.api.APIRest.enuns.EnunUsuarios;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

@Setter
@Entity
@Table(name="tb_user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id")
    private Long id;
    private String login;
    private String password;
    private EnunUsuarios roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + roles.toString()));
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
  /* @NotBlank
    private String name;
    @Email
    @Column(name="e_mail",unique = true)
    private String e_mail;
    @Column(name="password",unique = true)
    private String password;
    private LocalDate date_register;
    public Usuario(UserDTO dados) {
        this.name = dados.name();
        this.e_mail = dados.e_mail();
        this.password = dados.password();
        this.date_register = dados.date_register();*/
    }

