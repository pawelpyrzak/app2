package com.example.demo.infrastructure.entity;

import com.example.demo.infrastructure.entity.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private String uuid;
    @Column(length = 160, nullable = false, unique = true)
    private String name;
    private String image;

    private int rating;
    @Column(length = 180, nullable = false, unique = true)
    private String comment;
    private double price;
    @ManyToOne
    @JoinColumn(name = "category_id")

    private Category category;

    public Product(String uuid, String name, String image, int rating, String comment, double price, Category category) {
        this.uuid = uuid;
        this.name = name;
        this.image = image;
        this.rating = rating;
        this.comment = comment;
        this.price = price;
        this.category = category;
    }
}
