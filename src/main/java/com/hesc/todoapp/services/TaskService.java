package com.hesc.todoapp.services;

import com.hesc.todoapp.entities.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findAll();
    List<Task> findByName(String name);
    List<Task> findById(Long id);
    Task save(Task task);
}
