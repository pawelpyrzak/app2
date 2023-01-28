package com.example.reviewapp.domain.service;

import com.example.reviewapp.domain.exception.AppExceptionCode;
import com.example.reviewapp.infrastructure.entity.Category;
import com.example.reviewapp.infrastructure.entity.Product;
import com.example.reviewapp.infrastructure.repository.CategoryRepository;
import com.example.reviewapp.infrastructure.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductService {
    private  final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public Product createProduct(String name, String image, int rating, double price, Category category, String comment) {
        Category categoryFromDb = categoryRepository.findByUuid(category.getUuid())
                .orElseThrow(AppExceptionCode.NO_SUCH_PRODUCT::createException);

        return productRepository.save(new Product(UUID.randomUUID().
                toString(), name, image, rating, comment, price, categoryFromDb));
    }

}
