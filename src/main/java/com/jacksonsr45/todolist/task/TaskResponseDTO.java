package com.jacksonsr45.todolist.task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public record TaskResponseDTO(
    UUID id,
	String description,
	String title,
	LocalDateTime startAt,
	LocalDateTime endAt,
	ArrayList<String> steps,
	String progress,
	String priority,
	UUID userId,
	LocalDateTime createdAt,
	LocalDateTime updatedAt
) {
}
