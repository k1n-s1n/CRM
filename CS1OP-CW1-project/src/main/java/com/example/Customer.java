package com.example;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private List<String> notes = new ArrayList<>();

    public Customer(String name, String address, String email, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public List<String> getNotes() {
        return notes;
    }
    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    public String Search(String filter) {
        switch (filter.toLowerCase()) {
            case "All":
                return "Name: " + this.name + "\nAddress: " + this.address + "\nEmail: " + this.email + "\nPhone Number: " + this.phoneNumber + "\nNote: " + this.notes;
            case "address":
                return "Address: " + this.address;
            case "email":
                return "Email: " + this.email;
            case "phoneNumber":
                return "Phone Number: " + this.phoneNumber;
            case "note":
                return "Notes: " + String.join("; ", notes);
            default:
                return "Invalid filter";
        }
    }
    
}
