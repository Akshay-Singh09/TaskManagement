package com.example.TaskManagement.service;

import com.example.TaskManagement.model.Task;
import com.example.TaskManagement.model.TaskStatus;
import com.example.TaskManagement.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTaskDetails() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskDetails(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> getTaskDetails(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    public List<Task> getTaskDetails(LocalDate dueDate) {
        return taskRepository.findByDueDate(dueDate);
    }

    public Task addTask(Task requestBody) {
        return taskRepository.save(requestBody);
    }

    public ResponseEntity<String> updateTaskDetails(Long id, Task requestBody) {
        return ResponseEntity.ok("");
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }
}
