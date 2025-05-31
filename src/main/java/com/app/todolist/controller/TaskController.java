package com.app.todolist.controller;

import com.app.todolist.dto.request.TaskCreateRequest;
import com.app.todolist.dto.request.TaskUpdateRequest;
import com.app.todolist.entity.Task;
import com.app.todolist.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")

public class TaskController {
    private final TodoService todoService;

    public TaskController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskCreateRequest request) {
        return todoService.createTodo(request);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return todoService.getAllTasks();
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable long id,@RequestBody TaskUpdateRequest request) {
        return todoService.updateTodo(id,request);
    }

    @DeleteMapping("/{id}")
    String deleteTask(@PathVariable long id) {
        todoService.deleteTodo(id);
        return "xoa thanh cong ";
    }
}
