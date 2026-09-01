package com.java.dto.request;

import java.util.Set;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Request object used to register a new user")
public class RegisteRequest {

	@Schema(description = "Full name of the user", example = "Daniel Wong")
	@NotBlank(message = "Name is required")
	@Size(max = 100)
	private String name;

	@Schema(description = "Unique username used for login", example = "daniel")
	@NotBlank(message = "User Name is required")
	@Size(max = 100)
	private String username;

	@Schema(description = "User email address", example = "daniel.wong@example.com")
	@NotBlank(message = "Email is required")
	@Email(message = "Email format is invalid")
	@Size(max = 100)
	private String email;

	@Schema(description = "User password", example = "Password123!")
	@NotBlank(message = "Password is required")
	@Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters")
	private String password;

	@Schema(description = "Roles assigned to the user", example = "[\"ROLE_USER\", \"ROLE_MANAGER\"]")
	@NotEmpty(message = "At least one role is required")
	@Size(max = 10, message = "Maximum 10 roles are allowed")
	private Set<String> roles;

}
