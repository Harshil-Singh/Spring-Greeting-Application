package com.spring.greetingapp.service;

import org.springframework.stereotype.Service;

@Service  // Marks this class as a Spring service component
public class GreetingService {

    // UC2: Default greeting message
    public String getGreetingMessage() {
        return "Hello World";
    }

    // UC3: Personalized Greeting based on User input
    public String getPersonalizedGreeting(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello " + firstName + " " + lastName;
        } else if (firstName != null) {
            return "Hello " + firstName;
        } else if (lastName != null) {
            return "Hello " + lastName;
        } else {
            return getGreetingMessage(); // Default "Hello World"
        }
    }
}
