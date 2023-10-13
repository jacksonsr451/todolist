package com.jacksonsr45.todolist.task;

import java.time.LocalDateTime;
import java.util.ArrayList;
public record TaskRequestDTO(
    String title,
	String description,
	LocalDateTime startAt,
	LocalDateTime endAt,
	ArrayList<String> steps,
	String progress,
	String priority
) {
    
}
