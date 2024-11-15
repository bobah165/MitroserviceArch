package com.example.demo.repository;

import com.example.demo.data.Person;
import jakarta.persistence.EntityNotFoundException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class PersonRepository {

  private final PersonJpaRepository personJpaRepository;

  @Transactional
  public Person savePerson(Person person) {
    return personJpaRepository.save(person);
  }

  @Transactional(readOnly = true)
  public Person getPerson(Person person) {
    var personId = person.getId();
    return personJpaRepository.findById(personId)
      .orElseGet(() -> personJpaRepository.save(person));
  }
}
