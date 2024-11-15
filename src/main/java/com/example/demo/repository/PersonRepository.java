package com.example.demo.repository;

import com.example.demo.data.User;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.repository.entity.Person;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
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
  public void savePerson(Person user) {
    personJpaRepository.save(user);
  }

  @Transactional
  public void deletePerson(Person user) {
    personJpaRepository.delete(user);
  }

  @Transactional(readOnly = true)
  public Person getPerson(String personId) {
    return personJpaRepository.findById(personId)
      .orElseThrow(()-> new EntityNotFoundException("Person with id " + personId + " not found"));
  }

  @Transactional(readOnly = true)
  public Optional<Person> getAuthPerson(String userName) {
    return personJpaRepository.findByName(userName);
  }
}
