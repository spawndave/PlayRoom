package com.academy.model.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product extends ModifierOptions{
    /*@Id
    private String brand;
    @Id
    private String name;*/

    private Integer price;
    @EmbeddedId
    private ProductId id;

}
