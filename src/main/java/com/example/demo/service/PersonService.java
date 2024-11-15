package com.example.demo.service;

import com.example.demo.repository.PersonRepository;
import com.example.demo.data.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PersonService {
  private final PersonRepository personRepository;

  @Transactional
  public Person addUser(Person person){
    var savedPerson = personRepository.getPerson(person);

    if (savedPerson.getId().equals(person.getId())) {
      var savedPersonVersion = savedPerson.getVersion();
      var currentVersion = person.getVersion();

      if (currentVersion <= savedPersonVersion) {
       return savedPerson;
      }
    }

    return personRepository.savePerson(person);
  }
}
