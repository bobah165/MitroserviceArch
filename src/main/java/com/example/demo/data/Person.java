package com.example.demo.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
  private String id;
  @Column(name = "name")
  private String name;
  @Column(name = "age")
  private Integer age;
  @Column(name = "version")
  private Integer version;
}
