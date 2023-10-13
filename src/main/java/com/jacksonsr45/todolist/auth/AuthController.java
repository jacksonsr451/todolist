package com.jacksonsr45.todolist.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class AuthController {
    
    @Autowired
    private AuthService authService;

    @PermitAll
    @PostMapping("/v1/auth/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequestDTO data) {
        var token = authService.login(data);
        return ResponseEntity.ok(token);
    }
}
