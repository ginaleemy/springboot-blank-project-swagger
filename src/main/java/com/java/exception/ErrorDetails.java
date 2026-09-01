package com.java.exception;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Standard API error response")
public class ErrorDetails {
	@Schema(description = "Date and time when the error occurred", example = "2026-09-01T19:30:00")
	private LocalDateTime timeStamp;

	@Schema(description = "HTTP status", example = "400 BAD_REQUEST")
	private String status;
	@Schema(description = "Error message", example = "Email already exists")
	private String message;
	@Schema(description = "API request path", example = "uri=/api/employees/1")
	private String details;
}
