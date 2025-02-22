package com.spring.greetingapp.controller;

import com.spring.greetingapp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController  // Marks this class as a REST API controller
@RequestMapping("/greeting")  // Base URL mapping for this controller
public class GreetingController {

    private final GreetingService greetingService;

    // Constructor Injection for Service Layer
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // UC1: Return JSON response for different HTTP Methods (excluding GET)
    @PostMapping
    public Map<String, String> postGreetingJson() {
        return Map.of("message", "Hello from Greeting App (POST)");
    }

    @PutMapping
    public Map<String, String> putGreetingJson() {
        return Map.of("message", "Hello from Greeting App (PUT)");
    }

    @DeleteMapping
    public Map<String, String> deleteGreetingJson() {
        return Map.of("message", "Hello from Greeting App (DELETE)");
    }

    // UC2: Use Service Layer for Greeting Message "Hello World"
    @GetMapping  // Now only UC2 handles GET requests
    public Map<String, String> getGreetingFromService() {
        String message = greetingService.getGreetingMessage();
        return Map.of("message", message);
    }
}
