package com.example.TaskManagement.service;

import com.example.TaskManagement.model.TaskStatus;
import com.example.TaskManagement.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public ResponseEntity<String> getTaskDetails() {
        return ResponseEntity.ok("");
    }

    public ResponseEntity<String> getTaskDetails(Long id) {
        return ResponseEntity.ok("");
    }

    public ResponseEntity<String> getTaskDetails(TaskStatus status) {
        return ResponseEntity.ok("");
    }

    public ResponseEntity<String> getTaskDetails(LocalDate dueDate) {
        return ResponseEntity.ok("");
    }

    public ResponseEntity<String> addTask() {
        return ResponseEntity.ok("");
    }

    public ResponseEntity<String> updateTaskDetails(Long id) {
        return ResponseEntity.ok("");
    }

    public ResponseEntity<String> deleteTaskById(Long id) {
        return ResponseEntity.ok("");
    }
}
