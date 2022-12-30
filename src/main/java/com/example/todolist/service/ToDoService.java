package com.example.todolist.service;

import com.example.todolist.dto.ToDoDto;
import com.example.todolist.entity.ToDoEntity;
import com.example.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    public void index(Model model) {
        List<ToDoEntity> todoList=toDoRepository.findAll();
        model.addAttribute("todoList",todoList);
    }

    public void create(String content) {

        ToDoEntity todo=new ToDoEntity();
        todo.setContent(content);
        Boolean completed=false;
        todo.setCompleted(completed);

        toDoRepository.save(todo);
    }

    public void delete(Long id) {
        ToDoEntity deleted=toDoRepository.findById(id).orElseThrow(()->new IllegalAccessError("삭제하려는 값이 없습니다"));

        toDoRepository.delete(deleted);
    }
}
