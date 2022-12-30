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

        if(content !=""){
            ToDoEntity todo=new ToDoEntity();
            todo.setContent(content);
            toDoRepository.save(todo);
        }

    }

    public void delete(Long id) {
        ToDoEntity deleted=toDoRepository.findById(id).orElseThrow(()->new IllegalAccessError("삭제하려는 값이 없습니다"));

        toDoRepository.delete(deleted);
    }

    public void edit(Long id,String content) {
        ToDoEntity edit=toDoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("수정 할 값이 없습니다"));
        if (content ==null){
            edit.setContent(edit.getContent());
        }else{
            edit.setContent(content);
        }
        toDoRepository.save(edit);
    }
}
