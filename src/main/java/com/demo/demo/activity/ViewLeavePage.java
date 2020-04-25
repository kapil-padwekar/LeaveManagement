package com.demo.demo.activity;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.demo.demo.employee.Employee;
import com.demo.demo.employee.EmployeeCreator;
import com.demo.demo.leave.Leave;
import com.demo.demo.leave.LeaveController;
import com.demo.demo.leave.LeaveType;

public class ViewLeavePage implements IActivityPage {

    Logger logger = Logger.getLogger(ViewLeavePage.class.getName());

    private LeaveController controller = new LeaveController();
    private Employee employee;

    public ViewLeavePage(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void display() {
        logger.info("View Leave");
        // b. Leaves consumed � by type of leave along with date on which the leave was
        // applied for
        List<Leave> appliedLeaves = controller.viewAppliedLeaves(this.employee);
        if (appliedLeaves != null) {
            appliedLeaves.forEach(leave -> logger.info(leave.toString()));
        }

        // a. Leaves remaining � by type of leave
        logger.info("Leave Type " + "Remaining Leaves");
        Map<LeaveType, Integer> remainingLeaves = controller.viewAvailableLeaves(employee);
        if (remainingLeaves != null) {
            remainingLeaves.entrySet()
                    .forEach(entry -> logger.info(entry.getKey().toString() + " " + entry.getValue().toString()));
        }

    }

    public static void main(String[] args) {
        Employee employee = EmployeeCreator.createEmployee(102);
        ViewLeavePage leavePage = new ViewLeavePage(employee);
        leavePage.display();
        leavePage.controller.apply(employee,
                new Leave(LeaveType.SICK, LocalDate.now(), LocalDate.now().plusDays(3), "3 Sick Leaves"));
        leavePage.controller.apply(employee,
                new Leave(LeaveType.SICK, LocalDate.now(), LocalDate.now().plusDays(1), "1 Sick Leave"));
        leavePage.controller.apply(employee,
                new Leave(LeaveType.CASUAL, LocalDate.now(), LocalDate.now().plusDays(1), "1 Casual Leave"));
        leavePage.display();
    }

}
