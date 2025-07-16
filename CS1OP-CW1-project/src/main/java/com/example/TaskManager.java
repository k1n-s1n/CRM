package com.example;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private static TaskManager instance;
    private List<Task> allTasks;
    private List<TaskObserver> observers;

    private TaskManager() {
        allTasks = new ArrayList<>();
        observers = new ArrayList<>();
    }
    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }
    public List<Task> getAllTasks() {
        return allTasks;
    }
    public void addTask(Task task) {
        allTasks.add(task);
    }
    public void removeTask(Task task) {
        allTasks.remove(task);
    }
    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(TaskObserver observer) {
        observers.remove(observer);
    }
    public void notifyObservers(Task task) {
        for (TaskObserver observer : observers) {
            observer.update(task);
        }
    }
    public List<Task> getTasksByCustomer(Customer customer) {
        return allTasks.stream()
                       .filter(task -> task.getCustomer().equals(customer))
                       .toList();
    }
    public void checkDueTasks() {
        for (Task task : allTasks) {
            if (!task.isCompleted() && task.getDueDate().isBefore(java.time.LocalDate.now())) {
                notifyObservers(task);
            }
        }
    }
}
