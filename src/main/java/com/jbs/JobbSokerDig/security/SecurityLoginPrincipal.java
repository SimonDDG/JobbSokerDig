package com.jbs.JobbSokerDig.security;

import com.jbs.JobbSokerDig.general.Login;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SecurityLoginPrincipal implements UserDetails {
    private Login login;

    public SecurityLoginPrincipal(Login login) {
        this.login = login;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String currentRole = login.getRole().trim();
        final List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + currentRole));
        return authorities;
    }

    @Override
    public String getPassword() {
        return login.getPassword().trim();
    }

    @Override
    public String getUsername() {
        return login.getUsername().trim();
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
