package com.academy.model.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ProductId {
    private String brand;
    private String name;
}
