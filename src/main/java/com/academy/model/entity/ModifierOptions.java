package com.academy.model.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class ModifierOptions {
    private String createdAt;
    private String createdBy;
}
