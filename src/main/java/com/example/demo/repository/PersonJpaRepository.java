package com.example.demo.repository;

import com.example.demo.data.Person;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonJpaRepository extends JpaRepository<Person, String> {

  @Lock(LockModeType.OPTIMISTIC)
  @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "300")})
  Person save(Person person);
}
