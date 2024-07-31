package com.academy.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
public class Size {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String description;
    private String size;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "size")
    @ToString.Exclude private List<Toy> toys;

}
