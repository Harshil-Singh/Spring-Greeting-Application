package com.spring.greetingapp.model;

import jakarta.persistence.*;

@Entity  // Marks this as a JPA entity
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
    private Long id;

    private String message;

    // Default constructor (required for JPA)
    public Greeting() {}

    // Constructor to initialize message
    public Greeting(String message) {
        this.message = message;
    }

    // Getter for ID
    public Long getId() {
        return id;
    }

    // Getter for message
    public String getMessage() {
        return message;
    }

    // Setter for message (Required for updating the greeting)
    public void setMessage(String message) {
        this.message = message;
    }
}
