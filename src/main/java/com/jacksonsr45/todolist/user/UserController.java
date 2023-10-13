package com.jacksonsr45.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.PermitAll;

@RestController
@RequestMapping("api/")
public class UserController {

    @Autowired
    private CreateUserService createUserService;

    @PermitAll
    @PostMapping("v1/users")
    public ResponseEntity<?> create(@RequestBody UserRequestDTO data) {
        try {
            var user = this.createUserService.execute(data);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
