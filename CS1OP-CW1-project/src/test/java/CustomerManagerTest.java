
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.example.Customer;
import com.example.CustomerManager;
public class CustomerManagerTest {

    @Test
    public void testAddCustomer() {
        CustomerManager manager = new CustomerManager();
        Customer customer = new Customer("Alice", "123 St", "alice@example.com", "0123456789");

        manager.addCustomer(customer);
        assertTrue(manager.getCustomers().contains(customer));
    }

    @Test
    public void testFindCustomerByName() {
        CustomerManager manager = new CustomerManager();
        Customer customer = new Customer("Bob", "456 St", "bob@example.com", "0987654321");
        manager.addCustomer(customer);

        Customer found = manager.findCustomerByName("Bob");
        assertSame(customer, found, "Expected to find the customer Bob");
    }
}
