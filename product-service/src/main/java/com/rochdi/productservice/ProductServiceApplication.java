package com.rochdi.productservice;

import com.rochdi.productservice.entities.Product;
import com.rochdi.productservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return args -> {
			List<Product> products = List.of(
					Product.builder()
							.name("Test 1")
							.description("good status")
							.imageUrl("test/product1.png")
							.clientId(1L)
							.build(),

					Product.builder()
							.name("Test 1")
							.description("good status")
							.imageUrl("test/product1.png")
							.clientId(1L)
							.build());
			productRepository.saveAll(products);
		};
	}

}
