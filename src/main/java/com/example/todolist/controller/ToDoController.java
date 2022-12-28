package com.example.todolist.controller;

import com.example.todolist.repository.ToDoRepository;
import com.example.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToDoController {

    @Autowired
    private ToDoService toDoService;


    @GetMapping("/todo")
    public String list(Model model){

        toDoService.index(model);

        return "index";
    }

    @PostMapping("/todo/create")
    public String create(String content){

        toDoService.create(content);

        return "redirect:/todo";
    }

}
