package com.example.backend.repository;

import com.example.backend.generic.AbstractEntityRepository;
import com.example.backend.model.Role;
import com.example.backend.model.ERole;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends AbstractEntityRepository<Role> {
    Optional<Role> findByName(ERole name);
}
