package com.app.todolist.service;

import com.app.todolist.dto.request.TaskCreateRequest;
import com.app.todolist.dto.request.TaskUpdateRequest;
import com.app.todolist.dto.response.TaskResponse;
import com.app.todolist.entity.Task;
import com.app.todolist.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TaskRepository taskRepository;

    public TodoService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTodo(TaskCreateRequest request) {
        Task task = new Task();

        task.setTitle(request.getTitle());
        task.setCompleted(false);

        return taskRepository.save(task);
    }

    public Task updateTodo(Long taskid, TaskUpdateRequest request) {
        Optional<Task> optionalTask = taskRepository.findById(taskid);

        if (!optionalTask.isPresent()) {
            throw new RuntimeException("Task not found with id: " + taskid);
        }

        Task task = optionalTask.get();

        task.setTitle(request.getTitle());
        task.setCompleted(false);

        return taskRepository.save(task);
    }



    public void deleteTodo(long id) {
        taskRepository.deleteById(id);
    }
}
