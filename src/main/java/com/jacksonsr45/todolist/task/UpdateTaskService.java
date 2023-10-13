package com.jacksonsr45.todolist.task;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacksonsr45.todolist.utils.GetAttributes;

@Service
public class UpdateTaskService {

    @Autowired
    private ITaskRepository repository;

    public TaskResponseDTO execute(TaskRequestDTO data, UUID id) {
        var task = repository.findById(id).orElseThrow();

        GetAttributes.copyProperties(data, task);
        var saved = repository.save(task);
        return this.createResponse(saved);
    
    }

    private TaskResponseDTO createResponse(TaskModel model) {
        return new TaskResponseDTO(
            model.getId(), model.getDescription(), model.getTitle(), model.getStartAt(),
            model.getEndAt(), model.getSteps(), model.getProgress(), model.getPriority(),
            model.getUserId(), model.getCreatedAt(), model.getUpdatedAt()
        );
    }
}
