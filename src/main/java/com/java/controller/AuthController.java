package com.java.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.request.LoginRequest;
import com.java.dto.request.RegisteRequest;
import com.java.dto.response.JwtAuthResponse;
import com.java.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
@Tag(
	    name = "Authentication",
	    description = "APIs for user registration, login, and JWT authentication"
	)
public class AuthController {

    private AuthService authService;

    // Build Register REST API
    @Operation(
            summary = "Register user",
            description = "Creates a new user account and returns a JWT authentication response."
        )
    @PostMapping("/register")
    public ResponseEntity<JwtAuthResponse> register(@RequestBody RegisteRequest registerDto){
    	JwtAuthResponse response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Build Login REST API
    @Operation(
            summary = "Login user",
            description = "Authenticates a user using login credentials and returns a JWT token."
        )
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginRequest loginDto){
    	System.out.println("---> login ="+loginDto.toString());
        JwtAuthResponse response = authService.login(loginDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
