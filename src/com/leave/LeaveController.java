package com.leave;

import java.util.List;
import java.util.Map;

import com.employee.Employee;

public class LeaveController {

    ILeaveService service = new LeaveService();

    public void apply(Employee employee, Leave leave) {
        service.apply(employee, leave);
    }

    public void cancel(Employee employee, Leave leave) {
        service.cancel(employee, leave);
    }

    public List<Leave> viewAppliedLeaves(Employee employee) {
        return service.viewAppliedLeaves(employee);
    }

    public void viewAll(Employee employee) {
        service.viewAll(employee);
    }

    public void update(Employee employee, Leave leave) {
        service.update(employee, leave);
    }

    public Map<LeaveType, Integer> viewAvailableLeaves(Employee employee) {
        return service.viewAvailableLeaves(employee);
    }

}
