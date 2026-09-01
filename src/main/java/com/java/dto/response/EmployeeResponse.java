package com.java.dto.response;

import com.java.enums.Gender;

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
@Schema(description = "Response object containing employee information")
public class EmployeeResponse {

	@Schema(description = "Unique employee ID", example = "1")
	private Long id;

	@Schema(description = "Employee first name", example = "Daniel")
	private String firstName;

	@Schema(description = "Employee last name", example = "Wong")
	private String lastName;

	@Schema(description = "Employee gender", example = "MALE")
	private Gender gender;

	@Schema(description = "Employee email address", example = "daniel.wong@example.com")
	private String email;
}
