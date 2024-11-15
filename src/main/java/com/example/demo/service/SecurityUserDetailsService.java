package com.example.demo.service;


import com.example.demo.repository.PersonRepository;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityUserDetailsService implements UserDetailsService {

  private final PersonRepository repository;


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return repository.getAuthPerson(username).map(person -> User.withUsername(username)
        .password(encodePass(person.getPass()))
        .roles(person.getRole())
        .build())
      .orElseThrow(() -> new UsernameNotFoundException("User not present"));
  }

  private String encodePass(String pass) {
    var passwordByte = Base64.getDecoder().decode(pass);
    var passwordString = new String(passwordByte, StandardCharsets.UTF_8);
    var bcrypt = new BCryptPasswordEncoder();
    return bcrypt.encode(passwordString);
  }
}
