package com.leave;

import java.util.List;
import java.util.Map;

import com.employee.Employee;

public class LeaveService implements ILeaveService {

    ILeaveRepository repository = new LeaveRepository();

    public void apply(Employee employee, Leave leave) {
        repository.apply(employee, leave);
    }

    @Override
    public void cancel(Employee employee, Leave leave) {
        repository.cancel(employee, leave);
    }

    @Override
    public List<Leave> viewAppliedLeaves(Employee employee) {
        return repository.viewAppliedLeaves(employee);
    }

    @Override
    public void viewAll(Employee employee) {
        repository.viewAll(employee);
    }

    @Override
    public void update(Employee employee, Leave leave) {
        repository.update(employee, leave);
    }

    @Override
    public Map<LeaveType, Integer> viewAvailableLeaves(Employee employee) {
        return repository.viewAvailableLeaves(employee);
    }

}
