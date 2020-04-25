package com.demo.demo.leave;

import java.util.List;
import java.util.Map;

import com.demo.demo.employee.Employee;

public interface ILeaveRepository {

    void apply(Employee employee, Leave leave);

    void cancel(Employee employee, Leave leave);

    List<Leave> viewAppliedLeaves(Employee employee);

    void viewAll(Employee employee);

    void update(Employee employee, Leave leave);

    Map<LeaveType, Integer> viewAvailableLeaves(Employee employee);

}
