package pro.sky.HW_2._3.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.HW_2._3.entity.Employee;
import pro.sky.HW_2._3.exeption.EmployeeAlreadyAddedException;
import pro.sky.HW_2._3.exeption.EmployeeNotFoundExection;
import pro.sky.HW_2._3.exeption.InvalidInputException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImp  implements EmployeeService{
    private static final int MAX_SIZE = 100;
    Map<String, Employee> employees = new HashMap<>(Map.of(
            "Ефим Бобров", new Employee("Ефим", "Бобров", 770, 1),
            "Тихон Гуляев", new Employee("Тихон", "Гуляев", 318, 2),
            "Савели Шашков", new Employee("Савели", "Шашков", 589, 3),
            "Остап Николаев", new Employee("Остап", "Николаев", 809, 1),
            "Алексей Шаров", new Employee("Алексей", "Шаров", 348, 2),
            "Дарья Вишнякова", new Employee("Дарья", "Вишнякова", 894, 3),
            "Астра Калашникова", new Employee("Астра", "Калашникова", 496, 1),
            "Роксана Беспалова", new Employee("Роксана", "Беспалова", 547, 2),
            "Хильда Лазарева", new Employee("Хильда", "Лазарева", 203, 3),
            "Дана Уварова", new Employee("Дана", "Уварова", 750, 1)
    ));

    @Override
    public Employee add(String firstName, String lastName, int salary, int department) {

        validateInput(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }



    @Override
    public Employee remove(String firstName, String lastName) {

        validateInput(firstName, lastName);
        var key = (firstName + " " + lastName);
        if (employees.containsKey(key)) {
            return employees.remove(key);
        }

        throw new EmployeeNotFoundExection();
    }


    @Override
    public Employee find(String firstName, String lastName) {
        validateInput(firstName, lastName);
        var key = (firstName + " " + lastName);
        if (employees.containsKey(key)) {
            return employees.get(key);
        }
        throw new EmployeeNotFoundExection();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    private void validateInput(String firstName, String lastName) {
        if (!(StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName))) {
            throw new InvalidInputException();
        }
    }

}