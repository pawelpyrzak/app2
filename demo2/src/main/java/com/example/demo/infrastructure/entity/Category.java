package com.example.demo.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String uuid;
    @Column(length = 60, nullable = false, unique = true)
    private String name;

    public Category(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }
}
