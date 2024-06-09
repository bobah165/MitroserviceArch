package com.example.demo.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "general", name = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
  @Id
  private UUID id;
  @Column(name = "name")
  private String name;
  @Column(name = "age")
  private Integer age;
}
