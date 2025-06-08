package com.app.todolist.mapper;

import com.app.todolist.dto.request.UserCreateRequest;
import com.app.todolist.dto.request.UserUpdateRequest;
import com.app.todolist.dto.response.UserResponse;
import com.app.todolist.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper (componentModel = "spring")
public interface   UserMapper {
    User toUser(UserCreateRequest request);

    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
