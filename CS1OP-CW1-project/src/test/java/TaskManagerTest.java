
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.example.Customer;
import com.example.Task;
import com.example.TaskManager;

public class TaskManagerTest {

    @Test
    public void testAddTask() {
        TaskManager taskManager = TaskManager.getInstance();
        Customer customer = new Customer("Carol", "789 St", "carol@example.com", "0112233445");
        Task task = new Task(customer, "Demo Task", LocalDate.now().plusDays(1));

        taskManager.addTask(task);
        assertTrue(taskManager.getAllTasks().contains(task));
    }

    @Test
    public void testGetTasksByCustomer() {
        TaskManager taskManager = TaskManager.getInstance();
        Customer customer = new Customer("Dave", "101 St", "dave@example.com", "0223344556");
        Task task = new Task(customer, "Another Task", LocalDate.now().plusDays(2));

        taskManager.addTask(task);
        assertEquals(1, taskManager.getTasksByCustomer(customer).size());
    }
}

