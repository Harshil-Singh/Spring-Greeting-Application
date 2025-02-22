package com.spring.greetingapp.controller;

import com.spring.greetingapp.model.Greeting;
import com.spring.greetingapp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // UC2: Default Greeting Message
    @GetMapping
    public Map<String, String> getGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreetingMessage());
        return response;
    }

    // UC3: Personalized Greeting
    @GetMapping("/personalized")
    public Map<String, String> getPersonalizedGreeting(@RequestParam(required = false) String firstName,
                                                       @RequestParam(required = false) String lastName) {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getPersonalizedGreeting(firstName, lastName));
        return response;
    }

    // UC4: Save Greeting Message
    @PostMapping("/save")
    public Map<String, String> saveGreeting(@RequestParam String message) {
        Greeting greeting = new Greeting(message);
        Greeting savedGreeting = greetingService.saveGreeting(greeting);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Greeting saved with ID: " + savedGreeting.getId());
        return response;
    }

    // UC5: Find Greeting by ID
    @GetMapping("/{id}")
    public Map<String, String> findGreetingById(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.findGreetingById(id));
        return response;
    }

    // 🔹 UC6: List All Greetings
    @GetMapping("/all")
    public Map<String, List<String>> getAllGreetings() {
        Map<String, List<String>> response = new HashMap<>();
        response.put("messages", greetingService.getAllGreetings());
        return response;
    }
}
