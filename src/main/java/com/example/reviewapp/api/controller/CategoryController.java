package com.example.reviewapp.api.controller;

import com.example.reviewapp.api.dto.responce.CategoryResponce;
import com.example.reviewapp.api.exception.AppExceptionHandler;
import com.example.reviewapp.domain.service.CategoryService;
import com.example.reviewapp.infrastructure.converter.DtoMapper;
import com.example.reviewapp.infrastructure.entity.Category;
import com.example.reviewapp.infrastructure.repository.CategoryRepository;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final DtoMapper dtoMapper;

    @GetMapping()
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation =
                            AppExceptionHandler.Error.class))),
                    @ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation =
                            AppExceptionHandler.Error.class)))
            })
    public ResponseEntity<List<CategoryResponce>> getCategories(){
        return ResponseEntity.ok(categoryService.getCategories().stream()
                .map(dtoMapper::mapToCategoryResponse)
                .collect(Collectors.toList()));
    }
    @PostMapping()
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation =
                            AppExceptionHandler.Error.class))),
                    @ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation =
                            AppExceptionHandler.Error.class)))
            })
    public ResponseEntity<CategoryResponce> createCategory(@RequestParam String categoryName) {
         Category category = categoryService.createCategory(categoryName);
         log.info("Created category");
         return ResponseEntity.ok(dtoMapper.mapToCategoryResponse(category));
    }


}





