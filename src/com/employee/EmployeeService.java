package com.employee;

public class EmployeeService {

    EmployeeRepository employeeRepository = new EmployeeRepository();

    public Boolean employeeExists(Integer employeeId) {
        return employeeRepository.contains(employeeId);
    }

    public Employee getEmployee(int userId) {
        return employeeRepository.getEmployee(userId);
    }

}
