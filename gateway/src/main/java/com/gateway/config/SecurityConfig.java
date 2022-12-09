package com.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;


@Configuration
public class SecurityConfig {//extends WebSecurityConfigurerAdapter {

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.cors(c -> {
//            CorsConfigurationSource source = s -> {
//                CorsConfiguration cc = new CorsConfiguration();
//                cc.setAllowCredentials(true);
////                cc.setAllowedOrigins(List.of("http://127.0.0.1:3000"));
////                cc.setAllowedHeaders(List.of("*"));
////                cc.setAllowedMethods(List.of("*"));
//                return cc;
//            };
//
//            c.configurationSource(source);
//        });
//        return http.oauth2ResourceServer(
//                        j -> j.jwt().jwkSetUri("http://localhost:8080/oauth2/jwks")
//                ).authorizeRequests()
//                .anyRequest().authenticated()
//                .and().build();
////        return http.build();
//    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity){
        serverHttpSecurity
//                .authorizeExchange()
//                .pathMatchers("/oauth2/add_new_user")
//                .permitAll()
//                .and()
                .authorizeExchange()
                .anyExchange()
                .authenticated()
                .and()
//                .oauth2Login();

                .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);
        return  serverHttpSecurity.build();
    }

}