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

    // UC4: Save a Greeting Message
    public Greeting saveGreeting(Greeting greeting) {
        return greetingRepository.save(greeting);
    }

    // UC5: Get a Greeting by ID
    public Optional<Greeting> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    // UC6: Get all Greeting Messages
    public Iterable<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    // UC7: Update a Greeting Message by ID
    public Optional<Greeting> updateGreeting(Long id, String newMessage) {
        return greetingRepository.findById(id).map(greeting -> {
            greeting.setMessage(newMessage);
            return greetingRepository.save(greeting);
        });
    }

    // UC8: Delete a Greeting Message by ID
    public boolean deleteGreeting(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
