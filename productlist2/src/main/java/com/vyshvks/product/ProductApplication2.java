package com.vyshvks.product;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Product service Rest API documentation",
				description ="Product service REST API",
				version = "V1",
				contact = @Contact(
						name = "Vyshnav",
						email = "vyshnavksaseendran03@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "",
				url = "example.com"
		)
)
@SpringBootApplication
public class ProductApplication2 {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication2.class, args);
	}

}
