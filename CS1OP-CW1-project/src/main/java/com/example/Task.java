package com.example;

import java.time.LocalDate;

public class Task{
    private Customer customer;
    private String description;
    private LocalDate dueDate;
    private boolean completed;

    public Task(Customer customer, String description, LocalDate dueDate) {
        this.customer = customer;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
    }
    public Customer getCustomer() {
        return customer;
    }
    public String getDescription() {
        return description;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void markAsCompleted() {
        this.completed = true;
    }
    @Override
    public String toString() {
        return "Task for " + customer.getName() +
        " | Description: " + description +
        " | Due Date: " + dueDate +
        " | Completed: " + completed;
    }
                
}
