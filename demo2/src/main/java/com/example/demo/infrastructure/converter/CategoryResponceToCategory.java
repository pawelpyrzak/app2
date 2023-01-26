package com.example.demo.infrastructure.converter;
import com.example.demo.api.dto.responce.CategoryResponce;
import com.example.demo.infrastructure.entity.Category;
import org.springframework.core.convert.converter.Converter;


public class CategoryResponceToCategory implements Converter<CategoryResponce, Category> {

    @Override
    public Category convert(CategoryResponce source) {
        return new Category(source.getUuid(), source.getName());
    }
}
