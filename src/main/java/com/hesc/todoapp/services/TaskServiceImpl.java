package com.hesc.todoapp.services;

import com.hesc.todoapp.entities.Task;
import com.hesc.todoapp.repos.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {


    @Autowired
    private TaskRepository taskRepository;

    public TaskServiceImpl() {
    }

    @Override
    public List<Task> findAll() {
        List<Task> all = new ArrayList<>();
        taskRepository.findAll().forEach(all::add);
        return all;
    }


    @Override
    public List<Task> findByName(String name) {
        return taskRepository.findByName(name);
    }

    @Override
    public List<Task> findById(Long id) {
        return taskRepository.findById(id);
    }


    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }


}
