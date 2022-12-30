package com.example.todolist.dto;

import com.example.todolist.entity.ToDoEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
public class ToDoDto {
    private Long id;
    private String content;


    public ToDoEntity toEntity() {

        return new ToDoEntity(null,content);
    }
}
