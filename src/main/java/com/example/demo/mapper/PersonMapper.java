package com.example.demo.mapper;

import com.example.demo.data.User;
import com.example.demo.data.UserRole;
import com.example.demo.repository.entity.Person;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

  public Person map(User user) {
    var person = new Person();
    person.setAge(user.getAge());
    person.setName(user.getName());
    person.setId(user.getId());
    person.setRole(user.getUserRole());
    return person;
  }

  public User map(Person person) {
    return User.builder()
      .id(person.getId().toString())
      .age(person.getAge())
      .name(person.getName())
      .userRole(person.getRole())
      .build();
  }
}
