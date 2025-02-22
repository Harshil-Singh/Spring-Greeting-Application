package com.spring.greetingapp.controller;

import com.spring.greetingapp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // UC1: JSON response for different HTTP methods (POST, PUT, DELETE)
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

    // UC2 & UC3: Use Service Layer for Greeting Message with optional name parameters
    @GetMapping
    public Map<String, String> getGreetingFromService(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {

        String message = greetingService.getPersonalizedGreeting(firstName, lastName);
        return Map.of("message", message);
    }
}
