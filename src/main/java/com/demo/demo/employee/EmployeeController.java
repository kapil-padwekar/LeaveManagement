package com.demo.demo.employee;

import java.util.List;

import com.demo.demo.activity.Activity;
import com.demo.demo.activity.ActivityController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    EmployeeService service = new EmployeeService();
    ActivityController activityController = new ActivityController();

    public List<Activity> showOptions(Employee employee) {
        return activityController.getActivities(employee);
    }

    @GetMapping("/home")
    public String home() {
        return "employee";
    }

}
