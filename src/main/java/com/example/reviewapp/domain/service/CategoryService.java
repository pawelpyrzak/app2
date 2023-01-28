package com.example.reviewapp.domain.service;

import com.example.reviewapp.infrastructure.entity.Category;
import com.example.reviewapp.infrastructure.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public Category createCategory(String name){
        return categoryRepository.save(new Category(UUID.randomUUID().toString(), name));
    }
    public List<Category> getCategories(){

        return categoryRepository.findAll();
    }
}
