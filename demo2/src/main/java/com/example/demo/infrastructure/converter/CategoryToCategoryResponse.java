package com.example.demo.infrastructure.converter;

import com.example.demo.api.dto.responce.CategoryResponce;
import com.example.demo.api.dto.responce.ProductResponce;
import com.example.demo.infrastructure.entity.Category;
import com.example.demo.infrastructure.entity.Product;
import org.springframework.core.convert.converter.Converter;

public class CategoryToCategoryResponse implements Converter<Category, CategoryResponce> {
    @Override
    public CategoryResponce convert(Category source) {
        return new CategoryResponce(source.getUuid(), source.getName());
    }
}
