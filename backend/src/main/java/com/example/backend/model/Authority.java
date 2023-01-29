package com.example.backend.model;


import com.example.backend.generic.AbstractEntity;
import com.example.backend.global.GlobalStrings;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authorities", schema = GlobalStrings.SCHEMA_NAME)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Authority extends AbstractEntity {
    String name;
}
