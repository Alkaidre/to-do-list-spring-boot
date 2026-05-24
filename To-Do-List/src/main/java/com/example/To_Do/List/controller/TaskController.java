package com.example.To_Do.List.controller;

import com.example.To_Do.List.entity.Task;

import com.example.To_Do.List.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @PostMapping
    public Task criar(@RequestBody Task task) {
        return  taskService.salvar(task);
    }

    @GetMapping
    public List<Task> todasTask() {
        return taskService.todasTask();
    }

    @GetMapping("/{id}")
    public Task encontraPeloId(@PathVariable Long id) {
        return  taskService.encontrarPeloId(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        taskService.deletarTask(id);
    }
}