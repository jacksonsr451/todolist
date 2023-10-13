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
        this.title = data.title();
        this.description = data.description();
        this.startAt = data.startAt();
        this.endAt = data.endAt();
        this.steps = data.steps();
        this.progress = data.progress();
        this.priority = data.priority();
    }

}
