package com.jacksonsr45.todolist.user;

public record UserRequestDTO(
    String name,
    String username,
    String email,
    String password
) { }
