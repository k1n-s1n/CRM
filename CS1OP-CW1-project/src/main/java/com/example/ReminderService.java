package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReminderService implements TaskObserver {
// ReminderService implements TaskObserver to notify about due tasks
// It prints a reminder message when a task is due
// This class is part of the Observer pattern implementation in the TaskManager system
    @Override
    public void update(Task task) {
        System.out.println("Reminder: Task for " + task.getCustomer().getName() +
                " is due on " + task.getDueDate() + ". Description: " + task.getDescription());
    }
    public void pendingTasksCustomer() {
        TaskManager taskManager = TaskManager.getInstance();
        for (Customer customer : SessionManager.getInstance().getOnline()) {
            System.out.println("Pending tasks for " + customer.getName() + ":");
            for (Task task : taskManager.getTasksByCustomer(customer)) {
                if (!task.isCompleted()) {
                    System.out.println(task);
                }
            }
        }
    }
    public void printTaskCompletionRates() {
    TaskManager taskManager = TaskManager.getInstance();
    List<Task> allTasks = taskManager.getAllTasks();

    Map<Customer, Integer> totalTasks = new HashMap<>();
    Map<Customer, Integer> completedTasks = new HashMap<>();

    for (Task task : allTasks) {
        Customer customer = task.getCustomer();
        totalTasks.put(customer, totalTasks.getOrDefault(customer, 0) + 1);
        if (task.isCompleted()) {
            completedTasks.put(customer, completedTasks.getOrDefault(customer, 0) + 1);
        }
    }

    for (Customer customer : totalTasks.keySet()) {
        int total = totalTasks.get(customer);
        int completed = completedTasks.getOrDefault(customer, 0);
        double completionRate = (total == 0) ? 0 : (completed * 100.0 / total);

        System.out.printf("Customer: %s — Completed: %d/%d (%.2f%%)%n",
                          customer.getName(), completed, total, completionRate);
        }
    }   
}
