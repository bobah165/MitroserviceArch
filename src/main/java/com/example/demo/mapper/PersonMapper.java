package com.example.demo.mapper;

import com.example.demo.data.User;
import com.example.demo.repository.entity.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

  public Person map(User user) {
    var person = new Person();
    person.setAge(user.getAge());
    person.setName(user.getName());
    person.setId(user.getId());
    return person;
  }

  public User map(Person person) {
    return User.builder()
      .id(person.getId())
      .age(person.getAge())
      .name(person.getName())
      .build();
  }
}
