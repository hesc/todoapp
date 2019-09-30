package com.hesc.todoapp.web;

import com.hesc.todoapp.entities.Task;
import com.hesc.todoapp.entities.TaskState;
import com.hesc.todoapp.services.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping(value = "/tasks")
public class TaskController {

    private final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String list(Model uiModel) {
        logger.info("Listing tasks");
        List<Task> tasks = taskService.findAll();
        uiModel.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping(value = "/{id}")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        List<Task> tasks = taskService.findById(id);
        uiModel.addAttribute("tasks", tasks);
        return "tasks";
    }

//
//    @GetMapping(value = "/edit/{id}")
//    public String updateForm(@PathVariable Long id, Model model) {
//        model.addAttribute("singer", lastCustomerService.findById(id));
//        return "update";
//    }

    @GetMapping(value = "/new")
    public String createForm(Model uiModel) {
        Task task = new Task();
        uiModel.addAttribute("task", task);
        return "update";
    }


    @PostMapping
    public String saveTask(@Valid Task task) {
        task.setState(TaskState.open);
        task.setCreated(LocalDate.now());
        taskService.save(task);
        return "redirect:/tasks/";
    }

}
