package com.example;

import java.time.LocalDate;

public class EntityFactory {

    // Factory method for creating a Customer
    public static Customer createCustomer(String name, String address, String email, String phoneNumber) {
        return new Customer(name, address, email, phoneNumber);
    }

    // Factory method for creating a Task
    public static Task createTask(Customer customer, String description, LocalDate dueDate) {
        return new Task(customer, description, dueDate);
    }

    // Factory method for creating a Communication
    public static Communication createCommunication() {
        return new Communication();
    }

    // Optionally, you could create default tasks or customers with common values
    public static Task createDefaultFollowUpTask(Customer customer) {
        return new Task(customer, "Follow-up Meeting", LocalDate.now().plusDays(7));
    }
}

