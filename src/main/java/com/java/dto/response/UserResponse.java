package com.java.dto.response;

import java.util.Set;

import com.java.entity.Role;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Response object containing user account information")
public class UserResponse {
	@Schema(description = "Unique user ID", example = "1")
	private Long id;

	@Schema(description = "Full name of the user", example = "Daniel Wong")
	private String name;

	@Schema(description = "Username of the user", example = "daniel")
	private String username;

	@Schema(description = "Email address of the user", example = "daniel.wong@example.com")
	private String email;

	@Schema(description = "Roles assigned to the user")
	private Set<Role> roles;
}
