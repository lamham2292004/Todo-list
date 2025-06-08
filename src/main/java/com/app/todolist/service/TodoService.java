package com.app.todolist.service;

import com.app.todolist.dto.request.TaskCreateRequest;
import com.app.todolist.dto.request.TaskUpdateRequest;
import com.app.todolist.dto.response.TaskResponse;
import com.app.todolist.entity.Task;
import com.app.todolist.mapper.TaskMapper;
import com.app.todolist.repository.TaskRepository;
import lombok.AccessLevel;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TodoService {
        TaskRepository taskRepository;

        TaskMapper taskMapper;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public TaskResponse createTodo(TaskCreateRequest request) {
        Task task = taskMapper.toTaskMapper(request);

        return taskMapper.toTaskResponse(taskRepository.save(task));
    }

    public TaskResponse updateTodo(Long taskId, TaskUpdateRequest request) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(()-> new RuntimeException("Task not found"));

        taskMapper.updateTask(task,request);

        return taskMapper.toTaskResponse(taskRepository.save(task));
    }



    public void deleteTodo(long id) {
        taskRepository.deleteById(id);
    }
}
