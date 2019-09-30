package com.hesc.todoapp.repos;

import com.hesc.todoapp.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, String> {
    public List<Task> findByName(String name);
    public List<Task> findById(Long id);
}
