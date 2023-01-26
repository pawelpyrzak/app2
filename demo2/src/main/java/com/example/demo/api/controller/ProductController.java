package com.example.demo.api.controller;

import com.example.demo.api.dto.request.ProductRequest;
import com.example.demo.api.dto.responce.ProductResponce;
import com.example.demo.domain.service.ProductService;
import com.example.demo.infrastructure.entity.Category;
import com.example.demo.infrastructure.entity.Product;
import com.example.demo.infrastructure.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;



@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ConversionService conversionService;
    private final ProductService productService;

    public static String uploadImage=System.getProperty("user.dir")+"/src/main/demo/imagedata";

//    @RequestMapping
//    public String getAllProducts(Model model) {
//        List<Product> products = productRepository.findAll();
//        model.addAttribute("products", products);
//        return "products";
//    }
//    @GetMapping(value = "/products/new")
//    public String newProduct(Model model) {
//        model.addAttribute("newProducts", new Product());
//        model.addAttribute("listCategories", new Product());
//        return "product_form";
//    }



    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<ProductResponce> createProduct(@RequestBody ProductRequest productRequest, @RequestParam("img")MultipartFile file) {
        Product product = productService.createProduct(productRequest.getName(), productRequest.getImage(), productRequest.getRating(),
                productRequest.getPrice(), conversionService.convert(
                        productRequest.getCategoryResponce(), Category.class), productRequest.getComment());
        return ResponseEntity.ok(conversionService.convert(product,ProductResponce.class));
    }
}

