package com.spring.greetingapp.service;

import com.spring.greetingapp.model.Greeting;
import com.spring.greetingapp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service  // Marks this class as a Spring service component
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

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

    // UC4: Save the Greeting Message in the Repository
    public Greeting saveGreeting(Greeting greeting) {
        return greetingRepository.save(greeting);
    }

    // 🔹 UC5: Find Greeting by ID
    public String findGreetingById(Long id) {
        Optional<Greeting> greeting = greetingRepository.findById(id);
        return greeting.map(Greeting::getMessage).orElse("Greeting not found");
    }
}
