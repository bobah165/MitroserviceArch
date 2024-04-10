package com.example.demo.controller;


import com.example.demo.data.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/health")
  public ResponseEntity getHealth() {
    var state = new Data();
    state.setStatus("OK");
    return ResponseEntity.ok(state);
  }
}
