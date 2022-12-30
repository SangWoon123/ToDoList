package com.example.todolist.controller;

import com.example.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ToDoRestController {
    @Autowired
    private ToDoService toDoService;

    @DeleteMapping("/todo/delete/{id}")
    public String delete(@PathVariable Long id){
        toDoService.delete(id);

        return "redirect:/todo";
    }
}
