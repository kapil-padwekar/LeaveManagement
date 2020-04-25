package com.demo.demo.activity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import com.demo.demo.employee.Employee;
import com.demo.demo.leave.Leave;
import com.demo.demo.leave.LeaveController;

public class CancelLeavePage implements IActivityPage {

    Logger logger = Logger.getLogger(CancelLeavePage.class.getName());

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    LeaveController controller = new LeaveController();
    private Employee employee;

    public CancelLeavePage(Employee employee) {
        this.employee = employee;
    }

    /**
     * @TODO take proper input and remove the selected leave.
     */
    @Override
    public void display() {
        logger.info("Cancel Leave");
        Leave[] leaves = controller.viewAppliedLeaves(employee).toArray(new Leave[0]);
        int index = 0;
        for (Leave item : leaves) {
            index++;
            logger.info(String.valueOf(index) + "." + item.toString());

        }
        controller.cancel(employee, leaves[0]);
    }

}
