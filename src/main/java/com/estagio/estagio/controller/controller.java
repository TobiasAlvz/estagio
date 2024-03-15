package com.estagio.estagio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.estagio.estagio.model.Task;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class controller {

    @GetMapping("/tasks")
    public String tasks() {
        return "tasks";

    }

    @PostMapping("/tasks")
    public void tasks(Task tasks) {

        System.out.println("Tarefa:" + tasks.getDescription());
    }

    @GetMapping("/register")
    public String register() {
        return "register";

    }
}
