package com.robihidayat.simpleauth.controller;

import com.robihidayat.simpleauth.entity.Task;
import com.robihidayat.simpleauth.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("tasks")
@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping
    public void addTask(@RequestBody Task task){
        taskRepository.save(task);
    }

    @GetMapping
    public List<Task> getTask(){
        return taskRepository.findAll();

    }

    @PutMapping("/{id}")
    public void editTask(@PathVariable long id, @RequestBody Task task) {
        Task existingTask = taskRepository.findById(id);
        Assert.notNull(existingTask, "Task not found");
        existingTask.setDescription(task.getDescription());
        taskRepository.save(existingTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id) {
        Task taskToDel = taskRepository.findById(id);
        taskRepository.delete(taskToDel);
    }

}
