package com.niharika.usermanagement.api;

import com.niharika.usermanagement.api.dto.CreateUserRequest;
import com.niharika.usermanagement.api.dto.UpdateUserRequest;
import com.niharika.usermanagement.api.dto.UserResponse;
import com.niharika.usermanagement.domain.UserStatus;
import com.niharika.usermanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  private final UserService service;

  public UserController(UserService service) {
    this.service = service;
  }

  @GetMapping
  public Page<UserResponse> list(@RequestParam(required = false) UserStatus status, Pageable pageable) {
    return service.list(status, pageable);
  }

  @GetMapping("/{id}")
  public UserResponse get(@PathVariable Long id) {
    return service.get(id);
  }

  @PostMapping
  public UserResponse create(@Valid @RequestBody CreateUserRequest req) {
    return service.create(req);
  }

  @PutMapping("/{id}")
  public UserResponse put(@PathVariable Long id, @Valid @RequestBody CreateUserRequest req) {
    return service.put(id, req);
  }

  @PatchMapping("/{id}")
  public UserResponse patch(@PathVariable Long id, @Valid @RequestBody UpdateUserRequest req) {
    return service.patch(id, req);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }
}
