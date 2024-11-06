package com.example.demo.data;

public enum UserRole {
  ADMIN("admin"),
  USER("user");

  private final String userRole;

  UserRole(String role) {
    this.userRole = role;
  }

  public String getRole() {
    return userRole;
  }

  public static UserRole getRole(String role) {
    if (role.equals("admin")){
      return ADMIN;
    }

    return USER;
  }
}
