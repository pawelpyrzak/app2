package com.example.demo.api.controller;

import com.example.demo.infrastructure.entity.Category;
import com.example.demo.infrastructure.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Slf4j
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping(value = "categories")
    public String listCategories(Model model){
        List<Category> listCategories = categoryRepository.findAll();
        model.addAttribute("listCategories", listCategories);
        log.info("Found list");
        return "categories";
    }
    @GetMapping(value = "/products/new")
    public String newCategory(Model model) {
        model.addAttribute("newCategory", new Category());
        return "category_form";
    }
    @PostMapping(value = "/categories/save")
    public String saveCategory(Category category) {
         categoryRepository.save(category);
         return "redirect:/categories";
    }


}





