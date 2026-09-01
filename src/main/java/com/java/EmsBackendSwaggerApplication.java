package com.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SpringBootApplication
@OpenAPIDefinition(
	    info = @Info(
	        title = "Employee Management System API",
	        version = "1.0",
	        description = "REST APIs for Employee Management, Authentication and JWT Security"
	    )
	)

	@SecurityScheme(
	    name = "Bearer Authentication",
	    type = SecuritySchemeType.HTTP,
	    scheme = "bearer",
	    bearerFormat = "JWT",
	    in = SecuritySchemeIn.HEADER
	)
public class EmsBackendSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsBackendSwaggerApplication.class, args);
	}

}
