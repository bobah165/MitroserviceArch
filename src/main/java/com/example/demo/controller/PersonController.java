package com.example.demo.controller;

import com.example.demo.data.Person;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/person")
public class PersonController {

  private final PersonService personService;

  @PostMapping("/save")
  public ResponseEntity savePerson(@RequestBody Person user) {
      var savedPerson = personService.addUser(user);
      return ResponseEntity.ok(savedPerson);
  }
}
