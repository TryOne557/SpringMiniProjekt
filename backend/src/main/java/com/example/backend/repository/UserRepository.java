package com.example.backend.repository;

import org.springframework.stereotype.Repository;
import com.example.backend.model.User;
import com.example.backend.generic.AbstractEntityRepository;

import java.util.Optional;

@Repository
public interface UserRepository extends AbstractEntityRepository<User> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
