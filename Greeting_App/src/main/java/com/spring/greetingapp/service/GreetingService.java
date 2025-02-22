package com.spring.greetingapp.service;

import com.spring.greetingapp.model.Greeting;
import com.spring.greetingapp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    // UC5: Find Greeting by ID
    public String findGreetingById(Long id) {
        return greetingRepository.findById(id)
                .map(Greeting::getMessage)
                .orElse("Greeting not found");
    }

    // UC6: List All Greetings
    public List<String> getAllGreetings() {
        return greetingRepository.findAll()
                .stream()
                .map(Greeting::getMessage)
                .collect(Collectors.toList());
    }

    // 🔹 UC7: Edit an Existing Greeting Message
    public String updateGreeting(Long id, String newMessage) {
        Optional<Greeting> optionalGreeting = greetingRepository.findById(id);
        if (optionalGreeting.isPresent()) {
            Greeting greeting = optionalGreeting.get();
            greeting.setMessage(newMessage);
            greetingRepository.save(greeting);
            return "Greeting updated successfully with ID: " + id;
        } else {
            return "Greeting not found with ID: " + id;
        }
    }
}
