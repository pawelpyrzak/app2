package com.example.demo.infrastructure.converter;
import com.example.demo.api.dto.responce.CategoryResponce;
import com.example.demo.api.dto.responce.ProductResponce;
import com.example.demo.infrastructure.entity.Product;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class ProductToProductResponse implements Converter<Product, ProductResponce> {
    private final ConversionService conversionService;

    public ProductToProductResponse(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public ProductResponce convert(Product source) {
        return new ProductResponce(source.getUuid(), source.getName(),source.getImage(), source.getRating(),
                source.getComment(), source.getPrice(), conversionService.convert(source.getCategory(), CategoryResponce.class));

    }
}
