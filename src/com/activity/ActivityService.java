package com.activity;

import java.util.Arrays;
import java.util.List;

import com.employee.Employee;
import com.employee.Role;

public class ActivityService {

    ActivityRepository activityRepository = new ActivityRepository();

    public List<Activity> getActivities(Employee employee) {

        if (employee.getRoles().containsAll(Arrays.asList(Role.HR, Role.SUPERVISOR))) {
            return activityRepository.getHRSupervisorOptions();
        } else if (employee.getRoles().contains(Role.HR)) {
            return activityRepository.getHROptions();
        } else if (employee.getRoles().contains(Role.SUPERVISOR)) {
            return activityRepository.getSupervisorOptions();
        } else {
            return activityRepository.getEmployeeOptions();
        }

    }
}
