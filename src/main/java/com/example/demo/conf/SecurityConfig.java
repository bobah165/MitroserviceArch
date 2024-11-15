package com.example.demo.conf;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  private final UserDetailsService userDetailsService;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .csrf(AbstractHttpConfigurer::disable)
      .authorizeHttpRequests(requests ->
        requests
          .requestMatchers(HttpMethod.POST, "/api/person/save").hasRole("admin")
          .requestMatchers(HttpMethod.POST, "/api/person/delete").hasRole("admin")
          .requestMatchers(HttpMethod.POST, "/api/person/update").hasAnyRole("admin", "user1")
          .requestMatchers(HttpMethod.GET, "/api/person/{userId}").hasAnyRole("admin", "user1")
          .requestMatchers(HttpMethod.GET, "/health").permitAll()
          .requestMatchers(HttpMethod.GET, "/health2").permitAll()
          .requestMatchers(HttpMethod.GET, "/health3").permitAll()
      )
      .httpBasic(Customizer.withDefaults());

    return http.build();
  }

  @Autowired
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService)
      .passwordEncoder(new BCryptPasswordEncoder());
  }
}
