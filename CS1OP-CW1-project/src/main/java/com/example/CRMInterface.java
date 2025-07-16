package com.example;

import java.time.LocalDate;
import java.util.Scanner;

public class CRMInterface {
    private final CustomerManager customerManager = new CustomerManager();
    private final Communication communication = EntityFactory.createCommunication();
    private final TaskManager taskManager = TaskManager.getInstance();
    private final ReminderService reminderService = new ReminderService();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        taskManager.addObserver(reminderService);

        while (true) {
            System.out.println("\n==== CRM SYSTEM MENU ====");
            System.out.println("1. Add Customer");
            System.out.println("2. Log Call");
            System.out.println("3. Log Email");
            System.out.println("4. Log Meeting");
            System.out.println("5. Add Task");
            System.out.println("6. Mark Task Completed");
            System.out.println("7. Show Completed Tasks");
            System.out.println("8. Show Pending Tasks");
            System.out.println("9. Mark customer offline");
            System.out.println("10. Show Task Completion Rates");
            System.out.println("11. Show Online Customers");
            System.out.println("12. Exit");
            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addCustomer();
                case "2" -> logCommunication("call");
                case "3" -> logCommunication("email");
                case "4" -> logCommunication("meeting");
                case "5" -> addTask();
                case "6" -> markTaskCompleted();
                case "7" -> showCompletedTasks();
                case "8" -> reminderService.pendingTasksCustomer();
                case "9" -> {
                    Customer customer = getCustomerByName();
                    if (customer != null) {
                        SessionManager.getInstance().markOffline(customer);
                        System.out.println("Customer marked offline.");
                    } else {
                        System.out.println("Customer not found.");
                    }
                }
                case "10" -> reminderService.printTaskCompletionRates();
                case "11" -> showOnlineCustomers();
                case "12" -> {
                    System.out.println("Exiting CRM. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void addCustomer() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        Customer customer = EntityFactory.createCustomer(name, address, email, phone);
        customerManager.addCustomer(customer);
        SessionManager.getInstance().addOnline(customer);
        System.out.println("Customer added and marked online.");
    }

    private void logCommunication(String type) {
        Customer customer = getCustomerByName();
        if (customer == null) return;
        String result = switch (type) {
            case "call" -> communication.Call(customer);
            case "email" -> communication.Email(customer);
            case "meeting" -> communication.Meeting(customer);
            default -> "Unknown communication type";
        };
        System.out.println(result);
    }

    private void addTask() {
        Customer customer = getCustomerByName();
        if (customer == null) return;

        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter due date (YYYY-MM-DD): ");
        LocalDate dueDate = LocalDate.parse(scanner.nextLine());

        Task task = EntityFactory.createTask(customer, description, dueDate);
        taskManager.addTask(task);
        taskManager.notifyObservers(task);
        System.out.println("Task added.");
    }

    private void markTaskCompleted() {
        Customer customer = getCustomerByName();
        if (customer == null) return;

        for (Task task : taskManager.getTasksByCustomer(customer)) {
            System.out.println(task);
        }
        System.out.print("Enter task description to complete: ");
        String desc = scanner.nextLine();

        for (Task task : taskManager.getTasksByCustomer(customer)) {
            if (task.getDescription().equalsIgnoreCase(desc)) {
                task.markAsCompleted();
                System.out.println("Task marked as completed.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    private void showCompletedTasks() {
        for (Task task : taskManager.getAllTasks()) {
            if (task.isCompleted()) {
                System.out.println(task);
            }
        }
    }

    private void showOnlineCustomers() {
        System.out.println("Online Customers:");
        for (Customer c : SessionManager.getInstance().getOnline()) {
            System.out.println("- " + c.getName());
        }
    }
    private void markCustomerOffline(Scanner scanner) {
    System.out.print("Enter customer name to mark as offline: ");
    String name = scanner.nextLine();
    Customer customer = customerManager.findCustomerByName(name);
    if (customer != null) {
        SessionManager.getInstance().markOffline(customer);
        System.out.println(customer.getName() + " marked as offline.");
    } else {
        System.out.println("Customer not found.");
        }
    }

    private Customer getCustomerByName() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        return customerManager.findCustomerByName(name);
    }
}
