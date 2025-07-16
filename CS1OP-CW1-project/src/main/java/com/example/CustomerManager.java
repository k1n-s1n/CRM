package com.example;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> customers = new java.util.ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }
    public List<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }

    /**
     * Search for a customer in the list of customers by name
     * @param customerName the name of the customer to search for
     * @return "name found: <name>" if the customer is found, "name not found: <name>" otherwise
     */
    public Customer findCustomerByName(String customerName) { //findCustomerByName
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(customerName)) {
                System.out.println("name found: " + customer.getName());
                return customer;
            }
        }
        System.out.println("Customer not found: " + customerName);
        return null;
    }
    
}
