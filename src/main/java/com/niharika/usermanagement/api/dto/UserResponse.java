package com.niharika.usermanagement.api.dto;

import com.niharika.usermanagement.domain.UserRole;
import com.niharika.usermanagement.domain.UserStatus;
import java.time.Instant;

public class UserResponse {
  public Long id;
  public String firstName;
  public String lastName;
  public String email;
  public UserRole role;
  public UserStatus status;
  public Instant createdAt;
  public Instant updatedAt;
}
