package com.example.demo.domain.service;

import com.example.demo.infrastructure.entity.Category;
import com.example.demo.infrastructure.entity.Product;
import com.example.demo.infrastructure.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(String name, String image, int rating, double price, Category category, String comment){

        return productRepository.save(new Product(UUID.randomUUID().
                toString(),name,image,rating,comment,price,category));
    }

}
