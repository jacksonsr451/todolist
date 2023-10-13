package com.jacksonsr45.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskService {

    @Autowired
    private ITaskRepository repository;

    public TaskResponseDTO execute(TaskRequestDTO data, UUID userId) throws TaskException {
        this.validateTaskExists(data);

        this.validateDateIsValid(data);

        var task = this.createModel(data, userId);

        return this.createResponse(task);
    }

    private void validateTaskExists(TaskRequestDTO data) throws TaskException {
        var taskExists = repository.findByTitle(data.title());

        if (taskExists != null) {
            throw new TaskException("Task already exists");
        }
    }

    private void validateDateIsValid(TaskRequestDTO data) throws TaskException {
        var currentDate = LocalDateTime.now();

        if (currentDate.isAfter(data.startAt()) || currentDate.isAfter(data.endAt())) {
            throw new TaskException("Start / End date must be after current date");
        }

        if (data.startAt().isAfter(data.endAt())) {
            throw new TaskException("Start date must be before end date");
        }
    }

    private TaskModel createModel(TaskRequestDTO data, UUID userId) {
        TaskModel model = new TaskModel(data);

        model.setUserId(userId);

        return repository.save(model);
    }

    private TaskResponseDTO createResponse(TaskModel model) {
        return new TaskResponseDTO(
            model.getId(), model.getDescription(), model.getTitle(), model.getStartAt(),
            model.getEndAt(), model.getSteps(), model.getProgress(), model.getPriority(),
            model.getUserId(), model.getCreatedAt(), model.getUpdatedAt()
        );
    }
}
