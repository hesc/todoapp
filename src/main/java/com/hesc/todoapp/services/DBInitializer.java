package com.hesc.todoapp.services;

import com.hesc.todoapp.entities.Task;
import com.hesc.todoapp.entities.TaskState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;


@Service
public class DBInitializer {

    private Logger logger = LoggerFactory.getLogger(DBInitializer.class);
    @Autowired
    TaskService taskService;

    @PostConstruct
    public void initDB() {
        logger.info("Starting database initialization...");
        Task task = new Task();
        task.setName("first");
        task.setDescription("the first task");
        task.setState(TaskState.done);
        task.setCreated(LocalDate.of(2019, Month.JANUARY, 10));
        task.setDue(LocalDate.of(2019, Month.APRIL, 1));
        task.setDone(LocalDate.of(2019, Month.FEBRUARY, 21));
        taskService.save(task);

        Task task2 = new Task();
        task2.setName("2nd");
        task2.setDescription("another task");
        task2.setCreated(LocalDate.of(2019, Month.MARCH, 10));
        task2.setDue(LocalDate.of(2019, Month.APRIL, 21));
        taskService.save(task2);

        logger.info("Database initialization finished.");
    }
}
