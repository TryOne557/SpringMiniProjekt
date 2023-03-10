package com.example.backend.model;

import com.example.backend.generic.AbstractEntity;
import com.example.backend.global.GlobalStrings;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", schema = GlobalStrings.SCHEMA_NAME,
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email"),
        })
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends AbstractEntity {
    @NotBlank
    @Size(max = 25)
    @Column(name = "username", nullable = false)
    String username;

    @NotBlank
    @Email
    @Column(name = "email", unique = true, nullable = false)
    String email;

    @NotBlank
    @Size(max = 120)
    @Column(name = "password", nullable = false)
    String password;



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            schema = GlobalStrings.SCHEMA_NAME,
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles = new HashSet<>();

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
