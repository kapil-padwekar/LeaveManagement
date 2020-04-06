package com.activity;

import java.util.logging.Logger;

import com.employee.Employee;
import com.leave.Leave;
import com.leave.LeaveController;

public class UpdateLeavePage implements IActivityPage {

    Logger logger = Logger.getLogger(UpdateLeavePage.class.getName());

    private Employee employee;
    LeaveController controller = new LeaveController();

    public UpdateLeavePage(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void display() {
        logger.info("Update Leave");
        Leave[] leaves = controller.viewAppliedLeaves(employee).toArray(new Leave[0]);
        int index = 0;
        for (Leave item : leaves) {
            index++;
            logger.info(String.valueOf(index) + "." + item.toString());

        }
        leaves[0].setReason("modified");
        controller.update(employee, leaves[0]);
    }

}
