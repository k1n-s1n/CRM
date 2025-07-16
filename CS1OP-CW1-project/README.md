# CS1OP-CW1 project

## Java CRM (Customer Relationship Manager)
This project is a Java-based Customer Relationship Manager (CRM) system designed to manage interactions with customers through tasks, communication logs, and reminders. Built using Object-Oriented Programming (OOP) principles, it integrates several key design patterns such as Factory, Observer, and Singleton, while also including a Command-Line Interface (CLI) for interactive usage. Maven and JUnit are used for dependency management and testing.

## Features
Customer Management
Add, remove, and search customers.

Store key information: name, address, email, phone number, and custom notes.

## Task Management
Create and assign tasks to customers.

Mark tasks as completed.

Check for overdue tasks via the ReminderService.

## Reminder & Reporting System
Utilizes the Observer Pattern to notify users of due tasks.

Generates per-customer task completion statistics.

Shows pending tasks for all online customers.

## Communication Logs
Log communication types: calls, emails, and meetings.

Notes can be attached and saved to text files.

View communication frequency per customer.

## Session Tracking
Track online and offline customers.

Toggle online/offline status via the CLI or session logic.

## Design Patterns Used
Factory Pattern: EntityFactory creates objects such as Customer, Task, and Communication in a centralized and reusable manner.

Observer Pattern: ReminderService observes the TaskManager and prints reminders for due tasks.

Singleton Pattern: TaskManager and SessionManager are single-instance controllers used across the application.

## Testing
Written with JUnit 5, covering CustomerManager and TaskManager.

Tested methods include adding, finding, and listing customers/tasks.

Additional tests can be added for communication logging and observer events.