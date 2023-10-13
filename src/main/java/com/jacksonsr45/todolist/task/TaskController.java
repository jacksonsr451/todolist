package com.jacksonsr45.todolist.task;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("api/")
public class TaskController {

    @Autowired
    private CreateTaskService createTaskService;

    @Autowired
    private GetTaskService getTaskService;

    @Autowired
    private UpdateTaskService updateTaskService;
    
    @PostMapping("v1/tasks")
    public ResponseEntity<?> create(@RequestBody TaskRequestDTO data, HttpServletRequest request) {
        
        try {
            UUID userId = (UUID) request.getAttribute("userId");
            var dto = createTaskService.execute(data, userId);
        
            return ResponseEntity.status(HttpStatus.CREATED).body(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("v1/tasks")
    public ResponseEntity<?> list(HttpServletRequest request) {
        try {
            UUID userId = (UUID) request.getAttribute("userId");
            return ResponseEntity.ok(getTaskService.execute(userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("v1/tasks/{id}")
    public ResponseEntity<?> update(@RequestBody TaskRequestDTO data, HttpServletRequest request, @PathVariable UUID id) {
        try {
            var userId = (UUID) request.getAttribute("userId");
            return ResponseEntity.ok(updateTaskService.execute(data, id, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
