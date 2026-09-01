package com.java.dto.response;

import java.util.Set;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "JWT authentication response returned after successful login or registration")
public class JwtAuthResponse {
	@Schema(description = "JWT access token used to access secured APIs", example = "eyJhbGciOiJIUzI1NiJ9...")
	private String accessToken;
	@Builder.Default
	@Schema(description = "Authentication token type", example = "Bearer")
	private String tokenType = "Bearer";

	@Schema(description = "Unique user ID", example = "1")
	private Long id;

	@Schema(description = "Full name of the authenticated user", example = "Daniel Wong")
	private String name;

	@Schema(description = "Username of the authenticated user", example = "daniel")
	private String username;

	@Schema(description = "Email address of the authenticated user", example = "daniel.wong@example.com")
	private String email;

	@Schema(description = "Roles assigned to the authenticated user", example = "[\"ROLE_USER\", \"ROLE_MANAGER\"]")
	private Set<String> roles;

	@Schema(description = "Current active role used by the user", example = "ROLE_MANAGER")
	private String currRole;
}
