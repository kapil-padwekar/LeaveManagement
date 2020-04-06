package com.activity;

import java.util.List;

import com.employee.Employee;

public class ActivityController {

    ActivityService service = new ActivityService();

    public List<Activity> getActivities(Employee employee) {
        return service.getActivities(employee);
    }

    public void display(Activity activity, Employee employee) {
        // @TODO Exception if invalid activity
        switch (activity) {
        case VIEWLEAVE:
            new ViewLeavePage(employee).display();
            break;
        case APPLYLEAVE:
            new ApplyLeavePage(employee).display();
            break;
        case CANCELLEAVE:
            new CancelLeavePage(employee).display();
            break;
        case CHANGEPOLICY:
            new ChangePolicyPage().display();
            break;
        case UPDATELEAVE:
            new UpdateLeavePage(employee).display();
            break;
        case VIEWALLLEAVE:
            new ViewAllLeavePage(employee).display();
            break;
        default:
            new ApplyLeavePage(employee).display();
        }
    }

}
