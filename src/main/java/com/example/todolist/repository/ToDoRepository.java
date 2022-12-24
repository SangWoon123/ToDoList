package com.example.todolist.repository;

import com.example.todolist.entity.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDoEntity,Long> {
}
