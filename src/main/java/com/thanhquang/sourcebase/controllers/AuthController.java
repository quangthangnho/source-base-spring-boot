package com.thanhquang.sourcebase.controllers;

import com.thanhquang.sourcebase.dto.response.auth.RegisterDto;
import com.thanhquang.sourcebase.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public void login() {
        // TODO
    }

    @PostMapping("/register")
    public void register(@Valid @RequestBody RegisterDto registerDto) {
        authService.register(registerDto);
    }
}
