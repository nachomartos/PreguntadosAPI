package com.preguntas.controllers;


import com.preguntas.dto.request.LoginRequest;
import com.preguntas.dto.request.RegisterRequest;
import com.preguntas.dto.response.AuthResponse;
import com.preguntas.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	/**
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
		AuthResponse authResponse = authService.register(request);
		return new ResponseEntity<>(authResponse, HttpStatus.OK);
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
		AuthResponse res = authService.login(request);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
