package com.example.authserver.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class CORSCustomizer {

  public void corsCustomizer(HttpSecurity http) throws Exception {
    http.cors(c -> {
      CorsConfigurationSource source = s -> {
        CorsConfiguration cc = new CorsConfiguration();
//        cc.setAllowCredentials();
        ArrayList list= new ArrayList();
        list.add("http://localhost:3000");
        cc.setAllowedOrigins(Collections.singletonList("*"));
        ArrayList list1= new ArrayList();
        list1.add("*");
        cc.addAllowedHeader("*");
        cc.setAllowedMethods(Arrays.asList("GET", "POST","PUT","DELETE","OPTIONS"));
        return cc;
      };

      c.configurationSource(source);
    });
  }
}
