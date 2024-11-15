package com.example.demo.service;

import com.example.demo.data.User;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.entity.Person;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
  private final PersonRepository personRepository;

  public void addUser(Person user){
    personRepository.savePerson(user);
  }

  public void deleteUser(Person user){
    personRepository.deletePerson(user);
  }

  public Person findUser(String userId){
    return personRepository.getPerson(userId);
  }

  public Optional<Person> findAuthUser(String userName){
    return personRepository.getAuthPerson(userName);
  }
}
