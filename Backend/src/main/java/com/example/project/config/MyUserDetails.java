package com.example.project.config;
import com.example.project.entity.Role;
import com.example.project.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails{

    private final User user;

    public MyUserDetails(User user) {
        this.user = user;
    }
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = user.getRoles();
        Iterator<Role> iterator = roles.iterator();
        List<String> titles = new ArrayList<>();
        while(iterator.hasNext()) {
            titles.add(iterator.next().getTitle());
        }
        return titles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }


    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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