package com.niharika.usermanagement.repo;

import com.niharika.usermanagement.domain.UserEntity;
import com.niharika.usermanagement.domain.UserStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
  Page<UserEntity> findByStatus(UserStatus status, Pageable pageable);
  boolean existsByEmail(String email);
}
