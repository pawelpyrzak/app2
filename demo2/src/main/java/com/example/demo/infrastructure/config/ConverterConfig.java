package com.example.demo.infrastructure.config;
import com.example.demo.infrastructure.converter.CategoryResponceToCategory;
import com.example.demo.infrastructure.converter.ProductToProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class ConverterConfig implements WebMvcConfigurer {
    @Lazy
    @Autowired
    private ConversionService conversionService;
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new CategoryResponceToCategory());
        registry.addConverter(new ProductToProductResponse(conversionService));
    }

}
