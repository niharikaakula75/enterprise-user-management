package com.niharika.usermanagement.service;

import com.niharika.usermanagement.api.dto.CreateUserRequest;
import com.niharika.usermanagement.api.dto.UpdateUserRequest;
import com.niharika.usermanagement.api.dto.UserResponse;
import com.niharika.usermanagement.domain.UserEntity;
import com.niharika.usermanagement.domain.UserStatus;
import com.niharika.usermanagement.repo.UserRepository;
import com.niharika.usermanagement.support.NotFoundException;
import com.niharika.usermanagement.support.ValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository repo;

  public UserService(UserRepository repo) {
    this.repo = repo;
  }

  public Page<UserResponse> list(UserStatus status, Pageable pageable) {
    Page<UserEntity> page = (status == null) ? repo.findAll(pageable) : repo.findByStatus(status, pageable);
    return page.map(UserService::toResponse);
  }

  public UserResponse get(Long id) {
    return toResponse(repo.findById(id).orElseThrow(() -> new NotFoundException("User not found: " + id)));
  }

  public UserResponse create(CreateUserRequest req) {
    if (repo.existsByEmail(req.getEmail())) {
      throw new ValidationException("Email already exists: " + req.getEmail());
    }
    UserEntity e = new UserEntity();
    e.setFirstName(req.getFirstName());
    e.setLastName(req.getLastName());
    e.setEmail(req.getEmail());
    e.setRole(req.getRole());
    e.setStatus(req.getStatus());
    return toResponse(repo.save(e));
  }

  public UserResponse put(Long id, CreateUserRequest req) {
    UserEntity e = repo.findById(id).orElseThrow(() -> new NotFoundException("User not found: " + id));
    if (!e.getEmail().equalsIgnoreCase(req.getEmail()) && repo.existsByEmail(req.getEmail())) {
      throw new ValidationException("Email already exists: " + req.getEmail());
    }
    e.setFirstName(req.getFirstName());
    e.setLastName(req.getLastName());
    e.setEmail(req.getEmail());
    e.setRole(req.getRole());
    e.setStatus(req.getStatus());
    return toResponse(repo.save(e));
  }

  public UserResponse patch(Long id, UpdateUserRequest req) {
    UserEntity e = repo.findById(id).orElseThrow(() -> new NotFoundException("User not found: " + id));
    if (req.getEmail() != null && !e.getEmail().equalsIgnoreCase(req.getEmail()) && repo.existsByEmail(req.getEmail())) {
      throw new ValidationException("Email already exists: " + req.getEmail());
    }
    if (req.getFirstName() != null) e.setFirstName(req.getFirstName());
    if (req.getLastName() != null) e.setLastName(req.getLastName());
    if (req.getEmail() != null) e.setEmail(req.getEmail());
    if (req.getRole() != null) e.setRole(req.getRole());
    if (req.getStatus() != null) e.setStatus(req.getStatus());
    return toResponse(repo.save(e));
  }

  public void delete(Long id) {
    if (!repo.existsById(id)) throw new NotFoundException("User not found: " + id);
    repo.deleteById(id);
  }

  private static UserResponse toResponse(UserEntity e) {
    UserResponse r = new UserResponse();
    r.id = e.getId();
    r.firstName = e.getFirstName();
    r.lastName = e.getLastName();
    r.email = e.getEmail();
    r.role = e.getRole();
    r.status = e.getStatus();
    r.createdAt = e.getCreatedAt();
    r.updatedAt = e.getUpdatedAt();
    return r;
  }
}
