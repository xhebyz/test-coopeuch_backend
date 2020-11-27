package cl.coopeuch.test.testback.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import cl.coopeuch.test.testback.db.entity.Task;
import cl.coopeuch.test.testback.exceptions.TaskNotFoundExceptions;

@RestController
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskRepository repository;

    TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/tasks")
    List<Task> all() {
        return repository.findAll();
    }

    @PostMapping("/tasks")
    Task saveTask(@RequestBody Task task) {
        Task newTask = new Task();
        newTask.setDescription(task.getDescription());
        newTask.setActive(task.getActive());
        newTask.setDateCreation(new Timestamp(new Date().getTime()));
        return repository.save(newTask);
    }

    @GetMapping("/tasks/{id}")
    Task get(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundExceptions(id));
    }

    @PutMapping("/tasks/{id}")
    Task updateTask(@RequestBody Task updateTask, @PathVariable Long id) {

        return repository.findById(id)
                .map(task -> {
                    task.setDescription(updateTask.getDescription());
                    return repository.save(task);
                })
                .orElseGet(() -> {
                    updateTask.setId(id);
                    return repository.save(updateTask);
                });
    }

    @DeleteMapping("/tasks/{id}")
    void removeTask(@PathVariable Long id) {
        repository.deleteById(id);
    }
}