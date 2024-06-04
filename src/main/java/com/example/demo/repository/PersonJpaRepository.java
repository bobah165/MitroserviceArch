package com.example.demo.repository;

import com.example.demo.repository.entity.Person;
import jakarta.persistence.Id;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonJpaRepository extends JpaRepository<Person, UUID> {
}
