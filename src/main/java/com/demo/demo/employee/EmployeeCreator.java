package com.demo.demo.employee;

import java.util.Arrays;

public class EmployeeCreator {

    public static Employee createEmployee(Integer id) {
        // @TODO Proper employee creation implementation.
        return new Employee(id, "XXX", Arrays.asList(Role.EMPLOYEE), null);
    }

    public boolean isSupervisor(Employee employee) {
        return employee.getRoles().contains(Role.SUPERVISOR);
    }
}
