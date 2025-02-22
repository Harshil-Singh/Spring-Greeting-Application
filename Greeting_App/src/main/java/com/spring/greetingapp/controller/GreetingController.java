package com.spring.greetingapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController  // Marks this class as a REST controller
@RequestMapping("/greeting")  // Base URL mapping for this controller
public class GreetingController {

    // UC1: Return a JSON response for a GET request
    @GetMapping
    public Map<String, String> getGreeting() {
        // Returning a JSON response with a greeting message
        return Map.of("message", "Hello from Greeting App");
    }
}
