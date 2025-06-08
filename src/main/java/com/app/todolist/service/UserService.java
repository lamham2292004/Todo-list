package com.app.todolist.service;

import com.app.todolist.dto.request.UserCreateRequest;
import com.app.todolist.dto.request.UserUpdateRequest;
import com.app.todolist.dto.response.UserResponse;
import com.app.todolist.entity.User;
import com.app.todolist.mapper.UserMapper;
import com.app.todolist.repository.UserReponsitory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

         UserReponsitory userReponsitory;

         UserMapper userMapper;


        public User createUser(UserCreateRequest request){

                User user = userMapper.toUser(request);

                return userReponsitory.save(user);
        }

        public UserResponse updateUser(Long userId, UserUpdateRequest request){
                User user = userReponsitory.findById(userId)
                        .orElseThrow(()->new RuntimeException("User Not Found"));

                userMapper.updateUser(user,request);
                return userMapper.toUserResponse(userReponsitory.save(user));
        }
      public List<User> getUser (){
                return userReponsitory.findAll();
      }

      public UserResponse getUserById(long id){
                return userMapper.toUserResponse( userReponsitory.findById(id)
                        .orElseThrow(()-> new RuntimeException("User not found")));
      }

      public void deleteUserById(long id){
                userReponsitory.deleteById(id);
      }
}
