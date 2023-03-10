package com.example.reviewapp.api.dto.request;

import com.example.reviewapp.api.dto.responce.CategoryResponce;
import com.example.reviewapp.infrastructure.entity.Category;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductRequest {

    @NotNull
    @NotBlank
    @NotEmpty
    @Max(value =200 )
    private String name;
    private String image;
    private int rating;
    @NotNull
    @NotBlank
    @NotEmpty
    @Max(value =1000)
    private String comment;
    private double price;
    private Category category;

}
