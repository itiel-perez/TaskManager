package com.example.TaskManager.controller;

import com.example.TaskManager.dao.TaskDAO;
import com.example.TaskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<TaskDAO> getAllTask(){
        return taskService.getAllTask();
    }

    @PostMapping("/task")
    public TaskDAO createTask(@RequestBody final TaskDAO taskDao){
        return taskService.createTask(taskDao);
    }

    @GetMapping("/task/{id}")
    public TaskDAO getTaskById(@PathVariable("id")final int id){
        return taskService.getTaskById(id);
    }

    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable("id")final int id){
        taskService.deleteTask(id);
    }

    @PostMapping("/task/{id}")
    public TaskDAO updateTask(@PathVariable("id")final int id, @RequestBody final TaskDAO taskDao){
        return taskService.updateTask(id, taskDao);
    }
}
