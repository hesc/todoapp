package com.hesc.todoapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class ToDoApplication {

    private static Logger logger = LoggerFactory.getLogger(ToDoApplication.class);

    public static void main(String... args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(ToDoApplication.class, args);
        assert (ctx != null);
        logger.info("Application started...");

    }
}
