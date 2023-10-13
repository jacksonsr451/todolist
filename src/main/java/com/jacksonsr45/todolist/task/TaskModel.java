package com.jacksonsr45.todolist.task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tb_tasks")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class TaskModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String description;

    @Column(unique = true, length = 50)
    private String title;

    private LocalDateTime startAt;

    private LocalDateTime endAt;

    private ArrayList<String> steps;

    private String progress;

    private String priority;

    private UUID userId;
    
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public TaskModel(TaskRequestDTO data) {
        this.setTitle(data.title());
        this.setDescription(data.description());
        this.setStartAt(data.startAt());
        this.setEndAt(data.endAt());
        this.setSteps(data.steps());
        this.setProgress(data.progress());
        this.setPriority(data.priority());
    }

    public void setTitle(String title) throws IllegalArgumentException {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }
        if (title.length() > 50) {
            throw new IllegalArgumentException("Title cannot be longer than 50 characters");
        }
        if (title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
    }

}
