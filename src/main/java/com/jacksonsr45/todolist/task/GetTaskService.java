package com.jacksonsr45.todolist.task;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class GetTaskService {
    @Autowired
    private ITaskRepository repository;

    public List<TaskResponseDTO> execute(UUID userId) throws TaskException {
        var tasks = repository.findAllByUserId(userId);
        if (tasks.isEmpty()) {
            throw new TaskException("No tasks found");
        }

        return toList(tasks);
    }

    private List<TaskResponseDTO> toList(List<TaskModel> tasks) {
        List<TaskResponseDTO> list = new ArrayList<>();
        for (TaskModel task : tasks) {
            list.add(new TaskResponseDTO(
                task.getId(), 
                task.getDescription(), 
                task.getTitle(), 
                task.getStartAt(), 
                task.getEndAt(), 
                task.getSteps(), 
                task.getProgress(), 
                task.getPriority(), 
                task.getUserId(), 
                task.getCreatedAt(), 
                task.getUpdatedAt()));
        }
        return list;
    }
}
