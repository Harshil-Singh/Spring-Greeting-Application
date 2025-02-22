package com.spring.greetingapp.model;

import jakarta.persistence.*;

@Entity  // Marks this as a JPA entity
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
    private Long id;

    private String message;

    public Greeting() {}

    public Greeting(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
