package com.example.demo.api.dto.responce;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class ProductResponce {
    private String uuid;
    private String name;
    private String image;
    private int rating;
    private String comment;
    private double price;
    private CategoryResponce categoryResponce;
}
