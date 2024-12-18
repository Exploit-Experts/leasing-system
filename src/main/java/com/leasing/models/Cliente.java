package com.leasing.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.UUID;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "UUID")
    private UUID id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String phone;

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
}
