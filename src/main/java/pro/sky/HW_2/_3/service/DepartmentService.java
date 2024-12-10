package pro.sky.HW_2._3.service;

import pro.sky.HW_2._3.entity.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee maxSalary(int departmentId);

    Employee minSalary(int departmentId);

    Collection<Employee> findForDepartment(int departmentId);

    Map<Integer, List<Employee>> allForDepartment();

    int sumSalaryForDepartment(int departmentId);
}
