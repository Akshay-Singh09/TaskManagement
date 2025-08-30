package com.example.TaskManagement.controller;

import com.example.TaskManagement.model.Task;
import com.example.TaskManagement.model.TaskStatus;
import com.example.TaskManagement.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks(
            @RequestParam(name = "status", required = false) TaskStatus status,
            @RequestParam(name = "dueDate", required = false) LocalDate dueDate) {
        if(status != null) {
            List<Task> task = taskService.getTaskDetails(status);
            return ResponseEntity.ok(task);
        } else if(dueDate != null) {
            List<Task> task = taskService.getTaskDetails(dueDate);
            return ResponseEntity.ok(task);
        } else {
            List<Task> task = taskService.getTaskDetails();
            return ResponseEntity.ok(task);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id) {
        return taskService.getTaskDetails(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task request) {
        return ResponseEntity.ok(taskService.addTask(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTask(@PathVariable("id") Long id, @RequestBody Task request) {
        return taskService.updateTaskDetails(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.ok("Task Deleted successfully for ID : " + id);
    }
}
