package com.spring.greetingapp.controller;

import com.spring.greetingapp.model.Greeting;
import com.spring.greetingapp.service.GreetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // UC2: Default greeting message
    @GetMapping("/default")
    public String getDefaultGreeting() {
        return greetingService.getGreetingMessage();
    }

    // UC3: Personalized Greeting based on User input
    @GetMapping("/personalized")
    public String getPersonalizedGreeting(@RequestParam(required = false) String firstName,
                                          @RequestParam(required = false) String lastName) {
        return greetingService.getPersonalizedGreeting(firstName, lastName);
    }

    // UC4: Save a Greeting Message
    @PostMapping("/save")
    public ResponseEntity<?> saveGreeting(@RequestParam String message) {
        Greeting savedGreeting = greetingService.saveGreeting(new Greeting(message));
        return ResponseEntity.ok(Map.of("message", "Greeting saved with ID: " + savedGreeting.getId()));
    }

    // UC5: Get a Greeting by ID (FIXED)
    @GetMapping("/{id}")
    public ResponseEntity<?> getGreetingById(@PathVariable Long id) {
        Optional<Greeting> greeting = greetingService.getGreetingById(id);
        if (greeting.isPresent()) {
            return ResponseEntity.ok(greeting.get());  // Returns JSON object
        } else {
            return ResponseEntity.status(404).body(Map.of("message", "Greeting not found!"));
        }
    }

    // UC6: Get all Greeting Messages
    @GetMapping("/all")
    public Iterable<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // UC7: Update a Greeting Message
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateGreeting(@PathVariable Long id, @RequestParam String message) {
        Optional<Greeting> updatedGreeting = greetingService.updateGreeting(id, message);
        return updatedGreeting.map(g -> ResponseEntity.ok(Map.of("message", "Greeting updated successfully!")))
                .orElse(ResponseEntity.status(404).body(Map.of("message", "Greeting not found!")));
    }

    // UC8: Delete a Greeting Message
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGreeting(@PathVariable Long id) {
        boolean deleted = greetingService.deleteGreeting(id);
        if (deleted) {
            return ResponseEntity.ok(Map.of("message", "Greeting deleted successfully!"));
        } else {
            return ResponseEntity.status(404).body(Map.of("message", "Greeting not found!"));
        }
    }
}
