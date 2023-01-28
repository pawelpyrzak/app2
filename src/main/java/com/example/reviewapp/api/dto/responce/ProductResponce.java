package com.example.reviewapp.api.dto.responce;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ProductResponce {
    private String uuid;
    private String name;
    private String image;
    private int rating;
    private String comment;
    private double price;
    private String categoryUuid;
    private String categoryName;
}
