package pro.sky.HW_2._3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.HW_2._3.entity.Employee;
import pro.sky.HW_2._3.service.DepartmentSericeImpl;
import pro.sky.HW_2._3.service.EmployeeServiceImp;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentSericeImplTest {

    @Mock
    private EmployeeServiceImp employeeServiceImp;
    @InjectMocks
    private DepartmentSericeImpl departmentSericeImpl;

    @Test
    void maxSalary() {
        Employee employee1 = new Employee("Иван", "Иванов", 100, 2);
        Employee employee2 = new Employee("Петр", "Петров", 150, 3);
        Employee employee3 = new Employee("Василий", "Васильев", 250, 3);
        List<Employee> employees = Arrays.asList(employee1, employee2, employee3);

        when(employeeServiceImp.findAll()).thenReturn(employees);

        Employee result = departmentSericeImpl.maxSalary(3);
        assertEquals(employee3, result);

        result = departmentSericeImpl.maxSalary(2);
        assertEquals(employee1, result);

        result = departmentSericeImpl.maxSalary(0);
        assertNull(result);
    }

    @Test
    void minSalary() {
        Employee employee1 = new Employee("Иван", "Иванов", 100, 2);
        Employee employee2 = new Employee("Петр", "Петров", 150, 3);
        Employee employee3 = new Employee("Василий", "Васильев", 250, 3);
        List<Employee> employees = Arrays.asList(employee1, employee2, employee3);

        when(employeeServiceImp.findAll()).thenReturn(employees);

        Employee result = departmentSericeImpl.minSalary(3);
        assertEquals(employee2, result);

        result = departmentSericeImpl.minSalary(2);
        assertEquals(employee1, result);

        result = departmentSericeImpl.minSalary(0);
        assertNull(result);

    }

    @Test
    void findForDepartment() {
        Employee employee1 = new Employee("Иван", "Иванов", 100, 2);
        Employee employee2 = new Employee("Петр", "Петров", 150, 3);
        Employee employee3 = new Employee("Василий", "Васильев", 250, 3);
        List<Employee> employees = Arrays.asList(employee1, employee2, employee3);

        when(employeeServiceImp.findAll()).thenReturn(employees);

        Collection<Employee> result = departmentSericeImpl.findForDepartment(3);
        assertEquals(2, result.size());
        assertTrue(result.contains(employee2) && result.contains(employee3));
        assertFalse(result.contains(employee1));

    }

    @Test
    void allForDepartment() {
        Employee employee = new Employee("Алексей", "Иванов", 100, 1);
        Employee employee1 = new Employee("Иван", "Иванов", 100, 1);
        Employee employee2 = new Employee("Петр", "Петров", 150, 2);
        Employee employee3 = new Employee("Василий", "Васильев", 250, 3);
        List<Employee> employees = Arrays.asList(employee, employee1, employee2, employee3);

        when(employeeServiceImp.findAll()).thenReturn(employees);

        Map<Integer, List<Employee>> expected = new HashMap<>();
        List<Employee> list = new ArrayList<>();
        List<Employee> list1 = new ArrayList<>();
        List<Employee> list2 = new ArrayList<>();
        list.add(employee);
        list.add(employee1);
        list1.add(employee2);
        list2.add(employee3);
        expected.put(1, list);
        expected.put(2, list1);
        expected.put(3, list2);

        Map<Integer, List<Employee>> actual = departmentSericeImpl.allForDepartment();

        assertEquals(expected, actual);


    }

    @Test
    void sumSalaryForDepartment() {
        Employee employee1 = new Employee("Иван", "Иванов", 100, 2);
        Employee employee2 = new Employee("Петр", "Петров", 150, 3);
        Employee employee3 = new Employee("Василий", "Васильев", 250, 3);
        List<Employee> employees = Arrays.asList(employee1, employee2, employee3);

        when(employeeServiceImp.findAll()).thenReturn(employees);

        int result = departmentSericeImpl.sumSalaryForDepartment(3);
        assertEquals(400, result);
        result = departmentSericeImpl.sumSalaryForDepartment(2);
        assertEquals(100, result);

    }

}
