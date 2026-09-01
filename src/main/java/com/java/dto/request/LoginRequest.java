package com.java.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Request object used for user login")
public class LoginRequest {

	@Schema(description = "Username or email used to login", example = "admin@example.com")
	@NotBlank(message = "User Name Or Email is required")
	@Size(max = 100)
	private String usernameOrEmail;

	@Schema(description = "User password", example = "Password123!")
	@NotBlank(message = "Password is required")
	@Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters")
	private String password;
}
