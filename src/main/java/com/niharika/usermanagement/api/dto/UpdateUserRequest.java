package com.niharika.usermanagement.api.dto;

import com.niharika.usermanagement.domain.UserRole;
import com.niharika.usermanagement.domain.UserStatus;
import jakarta.validation.constraints.Email;

public class UpdateUserRequest {
  private String firstName;
  private String lastName;
  @Email
  private String email;
  private UserRole role;
  private UserStatus status;

  public String getFirstName() { return firstName; }
  public void setFirstName(String firstName) { this.firstName = firstName; }
  public String getLastName() { return lastName; }
  public void setLastName(String lastName) { this.lastName = lastName; }
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
  public UserRole getRole() { return role; }
  public void setRole(UserRole role) { this.role = role; }
  public UserStatus getStatus() { return status; }
  public void setStatus(UserStatus status) { this.status = status; }
}
