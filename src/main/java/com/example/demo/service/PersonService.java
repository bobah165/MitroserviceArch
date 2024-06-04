package com.example.demo.service;

import com.example.demo.data.User;
import com.example.demo.repository.PersonRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
  private final PersonRepository personRepository;

  public void addUser(User user){
    personRepository.savePerson(user);
  }

  public void deleteUser(User user){
    personRepository.deletePerson(user);
  }

  public User findUser(UUID userId){
    return personRepository.getPerson(userId);
  }
}
