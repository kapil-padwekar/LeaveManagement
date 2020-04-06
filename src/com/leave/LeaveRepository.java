package com.leave;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.employee.Employee;
import com.employee.EmployeeCreator;

public class LeaveRepository implements ILeaveRepository {

    private static EnumMap<LeaveType, Integer> maxLimits = new EnumMap<>(LeaveType.class);
    private static Map<Integer, List<Leave>> appliedLeaves = new HashMap<>();
    private static Map<Integer, Map<LeaveType, Integer>> availableLeaves = new HashMap<>();

    static {
        maxLimits.put(LeaveType.CASUAL, 6);
        maxLimits.put(LeaveType.SICK, 8);
        maxLimits.put(LeaveType.EARNED, 4);
        maxLimits.put(LeaveType.LWP, 3);
    }

    public Integer getMaxLimit(LeaveType leaveType) {
        return maxLimits.get(leaveType);
    }

    public void changeMaxLimit(LeaveType leaveType, Integer newLimit) {
        maxLimits.put(leaveType, newLimit);
    }

    private Map<LeaveType, Integer> getAvailableLeaves(Integer empId) {
        if (!availableLeaves.containsKey(empId)) {
            Map<LeaveType, Integer> maxLeaveLimits = maxLimits.entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            availableLeaves.put(empId, maxLeaveLimits);
        }
        return availableLeaves.get(empId);
    }

    private List<Leave> getAppliedLeaves(Integer empId) {
        if (!appliedLeaves.containsKey(empId)) {
            List<Leave> list = new ArrayList<>();
            appliedLeaves.put(empId, list);
        }
        return appliedLeaves.get(empId);
    }

    private void addAppliedLeaves(Employee employee, Leave leave) {
        int id = employee.getId();
        List<Leave> list = getAppliedLeaves(id);
        list.add(leave);
        appliedLeaves.put(id, list);
    }

    private void removeAppliedLeaves(Employee employee, Leave leaveToCancel) {
        int id = employee.getId();
        List<Leave> list = getAppliedLeaves(id);
        list.remove(leaveToCancel);
        appliedLeaves.put(id, list);
    }

    private void updateAppliedLeaves(Employee employee, Leave leaveToUpdate) {
        int id = employee.getId();
        List<Leave> list = getAppliedLeaves(id);
        List<Leave> updatedList = list.stream().dropWhile(leave -> leave.getId().equals(leaveToUpdate.getId()))
                .collect(Collectors.toList());
        updatedList.add(leaveToUpdate);
        appliedLeaves.put(employee.getId(), updatedList);
    }

    @Override
    public void apply(Employee employee, Leave leave) {
        int id = employee.getId();
        LeaveType leaveType = leave.getLeaveType();
        Integer noOfDays = leave.getNoOfDays();
        Map<LeaveType, Integer> limits = getAvailableLeaves(id);
        Integer remainingLeaves = limits.get(leaveType);

        if (noOfDays <= remainingLeaves) {
            limits.put(leaveType, remainingLeaves - noOfDays);
            addAppliedLeaves(employee, leave);
        }
    }

    @Override
    public void cancel(Employee employee, Leave leaveToCancel) {
        removeAppliedLeaves(employee, leaveToCancel);
    }

    @Override
    public List<Leave> viewAppliedLeaves(Employee employee) {
        return getAppliedLeaves(employee.getId());
    }

    @Override
    public void update(Employee employee, Leave leaveToUpdate) {
        updateAppliedLeaves(employee, leaveToUpdate);
    }

    @Override
    public void viewAll(Employee employee) {
    }

    @Override
    public Map<LeaveType, Integer> viewAvailableLeaves(Employee employee) {
        return getAvailableLeaves(employee.getId());
    }

    public static void main(String[] args) {
        LeaveRepository repository = new LeaveRepository();
        Employee employee = EmployeeCreator.createEmployee(102);
        repository.viewAvailableLeaves(employee);
        repository.apply(employee, new Leave(LeaveType.CASUAL, LocalDate.now(), LocalDate.now().plusDays(3), "Test"));
        repository.viewAppliedLeaves(employee);
        repository.viewAvailableLeaves(employee);
    }

}
