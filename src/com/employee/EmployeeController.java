package com.employee;

import java.util.List;

import com.activity.Activity;
import com.activity.ActivityController;

public class EmployeeController {

    EmployeeService service = new EmployeeService();
    ActivityController activityController = new ActivityController();

    public List<Activity> showOptions(Employee employee) {
        return activityController.getActivities(employee);
    }

}
