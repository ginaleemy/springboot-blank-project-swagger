package com.java.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.request.EmployeeRequest;
import com.java.dto.response.EmployeeResponse;
import com.java.exception.ErrorDetails;
import com.java.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
@Validated
@Tag(name = "Springboot Blank Project API", description = "Springboot Blank Project Employee management APIs")
public class EmployeeController {
	private EmployeeService employeeService;

	// Build Add Employee REST API - url:
	// http://localhost:8080/ems-backend/api/employees
	@Operation(summary = "Create employees", description = "Creates one or more employees. Only users with ADMIN role can access this API.")
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<List<EmployeeResponse>> createEmployee(@RequestBody List<@Valid EmployeeRequest> request) {
		List<EmployeeResponse> savedEmployee = employeeService.createEmployee(request);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	// Build Get Employee REST API url:
	// http://localhost:8080/ems-backend/api/employees/{id}
	@Operation(summary = "Get employee by ID", description = "Retrieves an employee using the employee ID. Only users with ADMIN role can access this API.")
	@ApiResponses({
	    @ApiResponse(
	        responseCode = "200",
	        description = "Employee found"
	    ),
	    @ApiResponse(
	        responseCode = "400",
	        description = "Invalid request",
	        content = @Content(
	            schema = @Schema(implementation = ErrorDetails.class)
	        )
	    ),
	    @ApiResponse(
	        responseCode = "404",
	        description = "Employee not found",
	        content = @Content(
	            schema = @Schema(implementation = ErrorDetails.class)
	        )
	    )
	})
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("{id}")
	public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable("id") Long employeeId) {
		EmployeeResponse employeeResponse = employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeResponse);
	}

	// Build Get All Employees REST API url: http://localhost:8080/ems-backend
	@Operation(summary = "Get all employees", description = "Retrieves all employees in the system. Only users with ADMIN role can access this API.")
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
		List<EmployeeResponse> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}

	// Build Update Employee REST API, url:
	// http://localhost:8080/ems-backend/api/employees/{id}
	@Operation(summary = "Update employee", description = "Updates an existing employee using the employee ID. Only users with ADMIN role can access this API.")
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("{id}")
	public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable("id") Long employeeId,
			@RequestBody @Valid EmployeeRequest updatedEmployee) {
		EmployeeResponse employeeRes = employeeService.updateEmployee(employeeId, updatedEmployee);
		return ResponseEntity.ok(employeeRes);
	}

	// Build Delete Employee REST API, url:
	// http://localhost:8080/ems-backend/api/employees/1
	@Operation(summary = "Delete employee", description = "Deletes an employee using the employee ID. Only users with ADMIN role can access this API.")
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee deleted Successfully");
	}

}
