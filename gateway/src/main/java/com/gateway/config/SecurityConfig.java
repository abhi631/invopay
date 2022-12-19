package com.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;



@Configuration
public class SecurityConfig {
    public static final String[] PUBLIC_URLS = {
            "/v3/api-docs",
            "/v2/api-docs",
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/webjars/**",
            "/actuator",
            "/zai/**",
            "/web/**"


    };

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity){
        serverHttpSecurity
                .authorizeExchange()
                .pathMatchers(PUBLIC_URLS)
                .permitAll()
                .and()
                .authorizeExchange()
                .anyExchange()
                .authenticated()
                .and()
                .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);
        return  serverHttpSecurity.build();
    }

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



}