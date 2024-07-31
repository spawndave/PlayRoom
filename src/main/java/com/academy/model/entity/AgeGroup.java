package com.academy.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AgeGroup {
    @Id
    private Long id;
    private int age;
    private String description;
}
