package com.example.runverse.repository;

import com.example.runverse.model.User;
import com.example.runverse.model.UserMetric;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String username);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

}
