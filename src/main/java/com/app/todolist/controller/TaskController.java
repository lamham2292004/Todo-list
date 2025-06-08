package com.app.todolist.controller;

import com.app.todolist.dto.request.TaskCreateRequest;
import com.app.todolist.dto.request.TaskUpdateRequest;
import com.app.todolist.dto.response.TaskResponse;
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
    public TaskResponse createTask(@RequestBody TaskCreateRequest request) {
        return todoService.createTodo(request);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return todoService.getAllTasks();
    }

    @PutMapping("/{todoId}")
    public TaskResponse updateTask(@PathVariable long todoId,@RequestBody TaskUpdateRequest request) {
        return todoService.updateTodo(todoId,request);
    }

    @DeleteMapping("/{todoId}")
    String deleteTask(@PathVariable long todoId) {
        todoService.deleteTodo(todoId);
        return "xoa thanh cong ";
    }
}
