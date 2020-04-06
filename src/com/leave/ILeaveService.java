package com.leave;

import java.util.List;
import java.util.Map;

import com.employee.Employee;

public interface ILeaveService {

    public void apply(Employee employee, Leave leave);

    public void cancel(Employee employee, Leave leave);

    public List<Leave> viewAppliedLeaves(Employee employee);

    public void viewAll(Employee employee);

    public void update(Employee employee, Leave leave);

    public Map<LeaveType, Integer> viewAvailableLeaves(Employee employee);
}
