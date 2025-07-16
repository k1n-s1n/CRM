package com.example;

import java.util.List;

public class SessionManager {
    private static SessionManager instance;
    private List<Customer> Online;
    private List<Customer> Offline;
    
    private SessionManager() {
        // Initialize the online and offline list
        Online = new java.util.ArrayList<>();
        Offline = new java.util.ArrayList<>();
    }
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }
    public List<Customer> getOnline() {
        return Online;
    }
    public List<Customer> getOffline() {
        return Offline;
    }
    public void addOnline(Customer customer) {
        Online.add(customer);
    }
    public void addOffline(Customer customer) {
        Offline.add(customer);
    }
    public void markOnline(Customer customer) {
    Offline.remove(customer);
    if (!Online.contains(customer)) {
        Online.add(customer);
    }
}
public void markOffline(Customer customer) {
    Online.remove(customer);
    if (!Offline.contains(customer)) {
        Offline.add(customer);
    }
}

}
