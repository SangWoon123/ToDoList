package com.example.todolist.controller;

import com.example.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToDoController {

    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping("/todo")
    public String list(Model model){

        return "index";
    }

}
