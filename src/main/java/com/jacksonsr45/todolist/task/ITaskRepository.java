package com.jacksonsr45.todolist.task;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {
    public TaskModel findByTitle(String title);
    public List<TaskModel> findAllByUserId(UUID userId);
}

