package com.hesc.todoapp.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "task")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String description;
    private TaskState state;
    private Integer prio;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate created;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate due;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate done;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) &&
                Objects.equals(name, task.name) &&
                Objects.equals(description, task.description) &&
                state == task.state &&
                Objects.equals(prio, task.prio) &&
                Objects.equals(created, task.created) &&
                Objects.equals(due, task.due) &&
                Objects.equals(done, task.done);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, state, prio, created, due, done);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public Integer getPrio() {
        return prio;
    }

    public void setPrio(Integer prio) {
        this.prio = prio;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getDue() {
        return due;
    }

    public void setDue(LocalDate due) {
        this.due = due;
    }

    public LocalDate getDone() {
        return done;
    }

    public void setDone(LocalDate done) {
        this.done = done;
    }
}
