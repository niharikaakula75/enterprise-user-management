package com.niharika.usermanagement.api.dto;

import com.niharika.usermanagement.domain.UserRole;
import com.niharika.usermanagement.domain.UserStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CreateUserRequest {
  @NotBlank
  private String firstName;
  @NotBlank
  private String lastName;
  @Email @NotBlank
  private String email;

  private UserRole role = UserRole.USER;
  private UserStatus status = UserStatus.ACTIVE;

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
