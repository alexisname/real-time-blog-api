package com.springboot.blog.controller;

import com.springboot.blog.payload.LoginDto;
import com.springboot.blog.payload.SignUpDto;
import com.springboot.blog.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")

public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    //build Login REST API
    @PostMapping(value = {"/login","/signin"})
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        String response = authService.login(loginDto);
        return ResponseEntity.ok(response);
    }

    //Build Signup api
    @PostMapping(value = {"/register","/signup"})
    public ResponseEntity<String> signUp(@RequestBody SignUpDto signUpDto){
        String response = authService.register(signUpDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}