package com.estagio.estagio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.estagio.estagio.model.Task;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class controller {

    List<Task> tasks = new ArrayList<>();

    @GetMapping("/tasks")
    public String tasksPage() {
        return "tasks";
    }

    @PostMapping("/tasks")
    public void addTask(@RequestBody Task task) {
        long id = tasks.size() + 1L;
        tasks.add(new Task(id, task.getDescription(), task.getPriority()));
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }
}
