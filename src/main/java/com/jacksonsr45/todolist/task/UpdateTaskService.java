package com.jacksonsr45.todolist.task;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacksonsr45.todolist.utils.GetAttributes;

@Service
public class UpdateTaskService {

    @Autowired
    private ITaskRepository repository;

    public TaskResponseDTO execute(TaskRequestDTO data, UUID id, UUID userId) throws TaskException {
        var task = this.repository.findByIdAndUserId(id, userId);
        
        this.validateTask(task);

        GetAttributes.copyProperties(data, task);
        var saved = repository.save(task);
        return this.createResponse(saved);
    
    }

    private void validateTask(TaskModel task) throws TaskException {
        if (task == null) {
            throw new TaskException("User don not has permission to update this task. Or task not found!");
        }
    }

    private TaskResponseDTO createResponse(TaskModel model) {
        return new TaskResponseDTO(
            model.getId(), model.getDescription(), model.getTitle(), model.getStartAt(),
            model.getEndAt(), model.getSteps(), model.getProgress(), model.getPriority(),
            model.getUserId(), model.getCreatedAt(), model.getUpdatedAt()
        );
    }
}
