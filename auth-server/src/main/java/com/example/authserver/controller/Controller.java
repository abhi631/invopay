package com.example.authserver.controller;

import com.example.authserver.model.LoginDTO;
import com.example.authserver.service.CustomAuthenticationProvider;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller

@CrossOrigin("*")
public class Controller {

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

//    @PostMapping("/login")
//    @CrossOrigin("*")
//    public boolean login(@RequestBody LoginDTO loginDTO){
//        customAuthenticationProvider.authenticate(UsernamePasswordAuthenticationToken.authenticated(loginDTO.getUsername(), loginDTO.getPassword(),null));
//        Map< String, Object > claims = new HashMap<>();
////        return Jwts.builder().setClaims(claims).setSubject(loginDTO.getUsername()).setIssuedAt(Date.valueOf(LocalDate.now())).setExpiration(Date.valueOf(LocalDate.now().plusDays(30))).signWith( SignatureAlgorithm.HS512, "secret" ).compact();
//        return true;
//    }

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

}
