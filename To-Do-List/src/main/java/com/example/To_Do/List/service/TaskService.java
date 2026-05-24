package com.example.To_Do.List.service;

import com.example.To_Do.List.entity.Task;
import com.example.To_Do.List.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task salvar(Task task){
        return taskRepository.save(task);
    }

    public List<Task> todasTask() {
        return taskRepository.findAll();
    }

    public Optional<Task> encontrarPeloId(Long id) {
        return  taskRepository.findById(id);
    }

    public void deletarTask(Long id) {
        taskRepository.deleteById(id);
    }


}