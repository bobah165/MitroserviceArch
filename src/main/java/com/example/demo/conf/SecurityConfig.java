package com.example.demo.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .csrf(AbstractHttpConfigurer::disable)
      .authorizeHttpRequests(requests ->
        requests
                .requestMatchers(HttpMethod.POST, "/api/person/save").hasRole("admin")
                .requestMatchers(HttpMethod.POST, "/api/person/delete").hasRole("admin")
                .requestMatchers(HttpMethod.POST, "/api/person/update").hasAnyRole("admin", "user")
                .requestMatchers(HttpMethod.GET, "/api/person/{userId}").hasAnyRole("admin", "user")
                .requestMatchers(HttpMethod.GET, "/health").permitAll()
                .requestMatchers(HttpMethod.GET, "/health2").permitAll()
                .requestMatchers(HttpMethod.GET, "/health3").permitAll()
        )
      .httpBasic(Customizer.withDefaults());

    return http.build();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth
      .inMemoryAuthentication()
      .withUser("admin").password("$2a$12$5jBRwdOuAuybFdhgRywv1ekYHN7NOujG7te44M3S8PXTUtVFuv6SW").roles("admin")
      .and()
      .withUser("user").password("$2a$12$5jBRwdOuAuybFdhgRywv1ekYHN7NOujG7te44M3S8PXTUtVFuv6SW").roles("user");
  }


}
