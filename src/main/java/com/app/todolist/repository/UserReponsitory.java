package com.app.todolist.repository;

import com.app.todolist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReponsitory extends JpaRepository<User, Long> {
}
