package com.example.demo.controller;

import com.example.demo.data.User;
import com.example.demo.service.PersonService;
import java.net.http.HttpResponse;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public ResponseEntity savePerson(@RequestBody User user) {
      var currentUser = (org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      if (currentUser.getUsername().equals("admin")) {
        personService.addUser(user);
        return ResponseEntity.ok("User saved");
      } else {
        return ResponseEntity.badRequest().body("User not found or you don't have permissions");
      }
  }

  @PostMapping("/update")
  public ResponseEntity updatePerson(@RequestBody User user) {
   var currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
   var userFromDB = personService.findAuthUser(user.getName())
     .orElseThrow();
   if (currentUser.equals(userFromDB.getUserName())) {
     personService.addUser(user);
   } else {
     return ResponseEntity.badRequest().body("User not found or you don't have permissions");
   }
    return ResponseEntity.ok("User updated");
  }

  @PostMapping("/delete")
  public ResponseEntity deletePerson(@RequestBody User user) {
    personService.deleteUser(user);
    return ResponseEntity.ok("User deleted");
  }

  @GetMapping("/{userId}")
  public ResponseEntity findPerson(@PathVariable("userId") UUID userId) {
    var user = personService.findUser(userId);
    return ResponseEntity.ok(user);
  }
}
