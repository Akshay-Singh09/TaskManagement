package com.example.TaskManagement.controller;

import com.example.TaskManagement.model.TaskStatus;
import com.example.TaskManagement.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<String> getAllTasks() {
        taskService.getTaskDetails();
        return ResponseEntity.ok("All tasks");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTaskById(@PathVariable("id") Long id) {
        taskService.getTaskDetails(id);
        return ResponseEntity.ok("Task with Id : " + id);
    }

    @PostMapping
    public ResponseEntity<String> createTask(@RequestBody String request) {
        taskService.addTask();
        return ResponseEntity.ok("Task Created for request : " + request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTask(@PathVariable("id") Long id, @RequestBody String request) {
        taskService.updateTaskDetails(id);
        return ResponseEntity.ok("Task Updated for ID : " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.ok("Task Deleted for ID : " + id);
    }

    @GetMapping
    public ResponseEntity<String> getTaskByStatus(@RequestParam("status") TaskStatus status) {
        taskService.getTaskDetails(status);
        return ResponseEntity.ok("");
    }

    @GetMapping
    public ResponseEntity<String> getTaskByDueDate(@RequestParam("dueDate") LocalDate dueDate) {
        taskService.getTaskDetails(dueDate);
        return ResponseEntity.ok("");
    }
}
