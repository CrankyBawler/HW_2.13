package pro.sky.HW_2._3;

import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Test;
import pro.sky.HW_2._3.entity.Employee;
import pro.sky.HW_2._3.exeption.EmployeeAlreadyAddedException;
import pro.sky.HW_2._3.exeption.EmployeeNotFoundExection;
import pro.sky.HW_2._3.service.EmployeeService;
import pro.sky.HW_2._3.service.EmployeeServiceImp;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImpTest {
    private final EmployeeService employeeService = new EmployeeServiceImp();

    Employee employee = new Employee("Иван", "Иванов", 100, 10);

    @Test
    void add() {
        Employee expected = new Employee("Иван", "Иванов", 100, 10);
        Employee actual = null;
        try {
            actual = employeeService.add("Иван", "Иванов", 100, 10);
        } catch (EmployeeAlreadyAddedException e) {
            throw new RuntimeException(e);
        }
        assertEquals(actual, expected);

    }

    @Test
    void remove() {
        Employee expected = null;
        try {
            expected = employeeService.add("Иван", "Иванов", 100, 10);
        } catch (EmployeeNotFoundExection | EmployeeAlreadyAddedException e) {
            throw new RuntimeException(e);
        }
        Employee actual = employeeService.remove("Иван", "Иванов");
        assertEquals(expected, actual);
    }

    @Test
    void find() {

        Employee expected = null;
        try {
            expected = employeeService.add("Иван", "Иванов", 100, 10);
        } catch (EmployeeNotFoundExection | EmployeeAlreadyAddedException e) {
            throw new RuntimeException(e);
        }

        Employee actual = employeeService.find("Иван", "Иванов");

        assertEquals(expected, actual);

    }

    @Test
    void findAll() {
        Employee employee1 = null;
        Employee employee2 = null;
        Employee employee3 = null;

        try {
            employee1 = employeeService.add("Иван", "Иванов", 100, 10);
        } catch (EmployeeAlreadyAddedException e) {
            throw new RuntimeException(e);
        }
        try {
            employee2 = employeeService.add("Алексей", "Алексеев", 50, 11);
        } catch (EmployeeAlreadyAddedException e) {
            throw new RuntimeException(e);
        }

        try {
            employee3 = employeeService.add("Андрей", "Андреев", 150, 12);
        } catch (EmployeeAlreadyAddedException e) {
            throw new RuntimeException(e);
        }

        Collection<Employee> allEmployess = employeeService.findAll();

        assertTrue(employeeService.findAll().contains(employee1));
        assertTrue(employeeService.findAll().contains(employee2));
        assertTrue(employeeService.findAll().contains(employee3));

    }


}


