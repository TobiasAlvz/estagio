package com.estagio.estagio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import com.estagio.estagio.model.Task;

@Controller
public class controller {

    List<Task> tasks = new ArrayList<>();

    @GetMapping("/create")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("create");
        mv.addObject("task", new Task());
        return mv;
    }

    @PostMapping("/create")
    public String create(Task task) {
        System.out.println("Get ID" + task.getId());

        if (task.getId() != null) {
            Task taskFind = tasks.stream().filter(taskItem -> task.getId().equals(taskItem.getId())).findFirst().get();
            tasks.set(tasks.indexOf(taskFind), task);
        } else {
            Long id = tasks.size() + 1L;
            tasks.add(new Task(id, task.getName(), task.getPriority(), false));
        }

        return "redirect:/list";
    }

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("tasks", tasks);
        return mv;
    }

    @GetMapping("/remove/{id}")
    public String remover(@PathVariable("id") Long id) {
        Task taskFind = tasks.stream().filter(task -> id.equals(task.getId())).findFirst().get();
        tasks.remove(taskFind);
        return "/sucess";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("create");
        Task taskFind = tasks.stream().filter(task -> id.equals(task.getId())).findFirst().get();
        mv.addObject("task", taskFind);
        return mv;
    }
}
