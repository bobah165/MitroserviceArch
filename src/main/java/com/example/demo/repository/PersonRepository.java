package com.example.demo.repository;

import com.example.demo.data.User;
import com.example.demo.mapper.PersonMapper;
import jakarta.persistence.EntityNotFoundException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class PersonRepository {

  private final PersonJpaRepository personJpaRepository;
  private final PersonMapper mapper;

  @Transactional
  public void savePerson(User user) {
    var person = mapper.map(user);
    personJpaRepository.save(person);
  }

  @Transactional
  public void deletePerson(User user) {
    var person = mapper.map(user);
    personJpaRepository.delete(person);
  }

  @Transactional(readOnly = true)
  public User getPerson(UUID personId) {
    var person = personJpaRepository.findById(personId)
      .orElseThrow(()-> new EntityNotFoundException("Person with id " + personId + " not found"));
    return mapper.map(person);
  }
}
