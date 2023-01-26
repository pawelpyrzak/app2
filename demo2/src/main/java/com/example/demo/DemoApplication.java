package com.example.demo;

import com.example.demo.api.controller.ProductController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		new File(ProductController.uploadImage).mkdir();
		SpringApplication.run(DemoApplication.class, args);
	}

}
