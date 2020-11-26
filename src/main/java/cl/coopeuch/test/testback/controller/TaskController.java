package cl.coopeuch.test.testback.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TaskController {
    @GetMapping("/tasks")
    public String get() {
        return "greeting";
    }

}