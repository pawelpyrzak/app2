package com.example.reviewapp.api.controller;

import com.example.reviewapp.api.dto.request.ProductRequest;
import com.example.reviewapp.api.dto.responce.ProductResponce;
import com.example.reviewapp.api.exception.AppExceptionHandler;
import com.example.reviewapp.domain.service.ProductService;
import com.example.reviewapp.infrastructure.converter.DtoMapper;
import com.example.reviewapp.infrastructure.entity.Category;
import com.example.reviewapp.infrastructure.entity.Product;
import com.example.reviewapp.infrastructure.repository.ProductRepository;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final DtoMapper dtoMapper;
    private final ProductService productService;

    public static String uploadImage=System.getProperty("user.dir")+"/src/main/demo/imagedata";
    private final ProductRepository productRepository;

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
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation =
                            AppExceptionHandler.Error.class))),
                    @ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation =
                            AppExceptionHandler.Error.class)))
            })
    public ResponseEntity<ProductResponce> createProduct(@RequestBody ProductRequest productRequest, @RequestParam("img") MultipartFile file) {
        Product product = productService.createProduct(
                productRequest.getName(), productRequest.getImage(), productRequest.getRating(),
                productRequest.getPrice(), productRequest.getCategory(), productRequest.getComment()
        );
        return ResponseEntity.ok(dtoMapper.mapToProductResponse(product));
    }
}

