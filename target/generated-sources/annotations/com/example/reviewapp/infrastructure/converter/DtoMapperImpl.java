package com.example.reviewapp.infrastructure.converter;

import com.example.reviewapp.api.dto.responce.CategoryResponce;
import com.example.reviewapp.api.dto.responce.ProductResponce;
import com.example.reviewapp.api.dto.responce.UserResponse;
import com.example.reviewapp.infrastructure.entity.Category;
import com.example.reviewapp.infrastructure.entity.Product;
import com.example.reviewapp.infrastructure.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-28T15:00:36+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class DtoMapperImpl implements DtoMapper {

    @Override
    public ProductResponce mapToProductResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        String categoryUuid = null;
        String categoryName = null;
        String uuid = null;
        String name = null;
        String image = null;
        int rating = 0;
        String comment = null;
        double price = 0.0d;

        categoryUuid = productCategoryUuid( product );
        categoryName = productCategoryName( product );
        uuid = product.getUuid();
        name = product.getName();
        image = product.getImage();
        rating = product.getRating();
        comment = product.getComment();
        price = product.getPrice();

        ProductResponce productResponce = new ProductResponce( uuid, name, image, rating, comment, price, categoryUuid, categoryName );

        return productResponce;
    }

    @Override
    public CategoryResponce mapToCategoryResponse(Category category) {
        if ( category == null ) {
            return null;
        }

        String uuid = null;
        String name = null;

        uuid = category.getUuid();
        name = category.getName();

        CategoryResponce categoryResponce = new CategoryResponce( uuid, name );

        return categoryResponce;
    }

    @Override
    public UserResponse mapToUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        String uuid = null;
        String firstName = null;
        String lastName = null;
        String email = null;

        uuid = user.getUuid();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        email = user.getEmail();

        UserResponse userResponse = new UserResponse( uuid, firstName, lastName, email );

        return userResponse;
    }

    private String productCategoryUuid(Product product) {
        if ( product == null ) {
            return null;
        }
        Category category = product.getCategory();
        if ( category == null ) {
            return null;
        }
        String uuid = category.getUuid();
        if ( uuid == null ) {
            return null;
        }
        return uuid;
    }

    private String productCategoryName(Product product) {
        if ( product == null ) {
            return null;
        }
        Category category = product.getCategory();
        if ( category == null ) {
            return null;
        }
        String name = category.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
