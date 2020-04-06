package com.activity;

import java.util.logging.Logger;

import com.employee.Employee;
import com.leave.LeaveController;

/**
 * Difficult to implement in single theaded env.
 * @author Kapsi
 *
 */
public class ViewAllLeavePage implements IActivityPage {

    Logger logger = Logger.getLogger(ViewAllLeavePage.class.getName());

    LeaveController controller = new LeaveController();
    private Employee employee;

    public ViewAllLeavePage(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void display() {
        logger.info("View All Leaves");
        // a. Details of leaves consumed by each employee in a financial year
        logger.info("Employee Name " + "Leave Type " + "Leave Consumed");
        controller.viewAll(employee);
    }

}
