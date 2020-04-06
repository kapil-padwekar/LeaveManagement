package com.login;

import com.employee.Employee;
import com.employee.EmployeeService;

public class LoginController {

    AuthenticationService service = new AuthenticationService();
    EmployeeService employeeService = new EmployeeService();

    private Boolean employeeExists(Integer userId) {
        return employeeService.employeeExists(userId);
    }

    public Employee authenticate(Integer userId, String password) {
        if (employeeExists(userId) && service.authenticate(userId, password)) {
            return employeeService.getEmployee(userId);
        }
        return null;
    }
}
