package com.example.authserver.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {

  private final CORSCustomizer corsCustomizer;

  public static final String[] PUBLIC_URLS = {
          "/v3/api-docs",
          "/v2/api-docs",
          "/swagger-resources/**",
          "/swagger-ui/**",
          "/webjars/**"
  };

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
            .antMatchers(PUBLIC_URLS).permitAll()
            .and()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin(form-> form.loginPage("/login").permitAll());
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance(); // only for demonstrations
  }
}
