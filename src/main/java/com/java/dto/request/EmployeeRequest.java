package com.java.dto.request;

import com.java.enums.Gender;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Request object for creating or updating an employee")
public class EmployeeRequest {

	@Schema(description = "Employee first name", example = "Daniel")
	@NotBlank(message = "First Name is required")
	@Size(max = 100)
	private String firstName;

	@Schema(description = "Employee last name", example = "Wong")
	@NotBlank(message = "Last Name is required")
	@Size(max = 100)
	private String lastName;

	@Schema(description = "Employee gender", example = "MALE")
	@NotNull(message = "Gender is required")
	private Gender gender;

	@Schema(description = "Employee email address", example = "daniel.wong@example.com")
	@NotBlank(message = "Email is required")
	@Email(message = "Email format is invalid")
	@Size(max = 100)
	private String email;
}
