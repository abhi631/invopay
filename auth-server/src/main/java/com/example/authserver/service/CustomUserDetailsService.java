package com.example.authserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.authserver.model.User user = userService.findUserByUsername(username);
        if(user == null){
            throw new RuntimeException("user not found by email");
        }
        List<String> roleslist = new ArrayList<>();
        roleslist.add("user");
        return new User( user.getEmail(),
                user.getOriginal_password(),
                getAuthorities(roleslist));

    }

    private Collection<? extends GrantedAuthority> getAuthorities (List<String> roles){
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(String role: roles){
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
