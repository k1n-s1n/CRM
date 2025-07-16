package com.example;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Communication {
    private Map<Customer, Integer> callCount = new HashMap<>();
    private Map<Customer, Integer> emailCount = new HashMap<>();
    private Map<Customer, Integer> meetingCount = new HashMap<>();

    public String Call(Customer customer) {
        String number = customer.getPhoneNumber();
        String name = customer.getName();
        String date = LocalDate.now().toString();
        String filename = name + "_" + date + ".txt";

        var path = Path.of(filename);
        try{
        BufferedWriter writer = Files.newBufferedWriter(path);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to add a note to the call? (yes/no)");
        String answer = scanner.nextLine();
        if (answer.equals("yes")) {
            System.out.println("Enter note:");
            String note = scanner.nextLine();
            writer.write(note);
        }
        writer.close();
    }
        catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        callCount.put(customer, callCount.getOrDefault(customer, 0) + 1);
        return "Call logged";
    }

    public String Email(Customer customer) {
        String number = customer.getPhoneNumber();
        String name = customer.getName();
        String date = LocalDate.now().toString();
        String filename = name + "_" + date + ".txt";

        var path = Path.of(filename);
        try{
        BufferedWriter writer = Files.newBufferedWriter(path);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to add a note to the email? (yes/no)");
        String answer = scanner.nextLine();
        if (answer.equals("yes")) {
            System.out.println("Enter note:");
            String note = scanner.nextLine();
            writer.write(note);
        }
        writer.close();
    }
        catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        emailCount.put(customer, emailCount.getOrDefault(customer, 0) + 1);
        return "Email logged";
    }

    public String Meeting(Customer customer) {
        String number = customer.getPhoneNumber();
        String name = customer.getName();
        String date = LocalDate.now().toString();
        String filename = name + "_" + date + ".txt";

        var path = Path.of(filename);
        try{
        BufferedWriter writer = Files.newBufferedWriter(path);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to add a note to the meeting? (yes/no)");
        String answer = scanner.nextLine();
        if (answer.equals("yes")) {
            System.out.println("Enter note:");
            String note = scanner.nextLine();
            writer.write(note);
        }
        writer.close();
    }
        catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        meetingCount.put(customer, meetingCount.getOrDefault(customer, 0) + 1);
        return "Meeting logged";
    }
    public int getCallCount(Customer customer) {
        return callCount.getOrDefault(customer, 0);
    }
    public int getEmailCount(Customer customer) {
        return emailCount.getOrDefault(customer, 0);
    }
    public int getMeetingCount(Customer customer) {
        return meetingCount.getOrDefault(customer, 0);
    }
}



