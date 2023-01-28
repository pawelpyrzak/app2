package com.example.reviewapp.infrastructure.converter;
import com.example.reviewapp.api.dto.responce.CategoryResponce;
import com.example.reviewapp.api.dto.responce.UserResponse;
import com.example.reviewapp.infrastructure.entity.Category;
import com.example.reviewapp.infrastructure.entity.Product;
import com.example.reviewapp.infrastructure.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import com.example.reviewapp.api.dto.responce.ProductResponce;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface DtoMapper {

    @Mapping(target = "categoryUuid", source = "category.uuid")
    @Mapping(target = "categoryName", source = "category.name")
    ProductResponce mapToProductResponse(Product product);

    CategoryResponce mapToCategoryResponse(Category category);
    UserResponse mapToUserResponse(User user);
}