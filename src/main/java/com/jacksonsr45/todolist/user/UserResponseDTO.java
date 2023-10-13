package com.jacksonsr45.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponseDTO(
    UUID id,
	String username,
	String name,
	String password,
	String email,
	String role,
	LocalDateTime createdAt,
	LocalDateTime updatedAt
) { }
