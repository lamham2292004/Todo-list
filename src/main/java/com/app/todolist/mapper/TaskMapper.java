package com.app.todolist.mapper;

import com.app.todolist.dto.request.TaskCreateRequest;
import com.app.todolist.dto.request.TaskUpdateRequest;
import com.app.todolist.dto.response.TaskResponse;
import com.app.todolist.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper (componentModel = "spring")
public interface TaskMapper {
    Task toTaskMapper(TaskCreateRequest request);

    void updateTask(@MappingTarget Task task, TaskUpdateRequest request);

    TaskResponse toTaskResponse(Task task);
}
