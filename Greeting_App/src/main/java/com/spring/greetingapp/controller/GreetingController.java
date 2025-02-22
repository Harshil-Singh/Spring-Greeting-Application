package com.spring.greetingapp.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController  // Marks this class as a REST API controller
@RequestMapping("/greeting")  // Base URL mapping for this controller
public class GreetingController {

    // UC1: Return JSON response for a GET request
    @GetMapping
    public Map<String, String> getGreeting() {
        return Map.of("message", "Hello from Greeting App (GET)");
    }

    // UC1: Return JSON response for a POST request
    @PostMapping
    public Map<String, String> postGreeting() {
        return Map.of("message", "Hello from Greeting App (POST)");
    }

    // UC1: Return JSON response for a PUT request
    @PutMapping
    public Map<String, String> putGreeting() {
        return Map.of("message", "Hello from Greeting App (PUT)");
    }

    // UC1: Return JSON response for a DELETE request
    @DeleteMapping
    public Map<String, String> deleteGreeting() {
        return Map.of("message", "Hello from Greeting App (DELETE)");
    }
}
