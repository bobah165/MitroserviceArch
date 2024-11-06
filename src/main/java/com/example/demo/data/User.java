package com.example.demo.data;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private String id;
  private String name;
  private Integer age;
  private String userRole;
  private String userName;
}
