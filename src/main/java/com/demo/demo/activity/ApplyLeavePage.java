package com.demo.demo.activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import com.demo.demo.employee.Employee;
import com.demo.demo.leave.Leave;
import com.demo.demo.leave.LeaveController;
import com.demo.demo.leave.LeaveType;

public class ApplyLeavePage implements IActivityPage {

    Logger loger = Logger.getLogger(ApplyLeavePage.class.getName());

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    LeaveController controller = new LeaveController();

    private Employee employee;

    public ApplyLeavePage(Employee employee) {
        this.employee = employee;
    }

    /**
     * @TODO - Allow only valid date. - startdate should not be after the end date.
     *       - validation if max limit for the leave type is exceeded.. Call
     *       Service: LeaveRepository.getMaxLimit
     */
    @Override
    public void display() {

        loger.info("Apply Leave : ");

        try {
            loger.info("Type of Leave : ");
            for (LeaveType type : LeaveType.values()) {
                loger.info(() -> type.getType() + "." + type.name());
            }
            int lt = Integer.parseInt(reader.readLine());
            LeaveType leaveType = LeaveType.getLeaveType(lt);
            loger.info("Start Date (dd/MM/yyyy): ");
            String st = reader.readLine();
            LocalDate startDate = LocalDate.parse(st, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            loger.info("End Date (dd/MM/yyyy): ");
            String ed = reader.readLine();
            LocalDate endDate = LocalDate.parse(ed, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            loger.info("Reason : ");
            String reason = reader.readLine();
            controller.apply(employee, new Leave(leaveType, startDate, endDate, reason));
        } catch (IOException e) {
            loger.warning("IOE " + e.getMessage());
        }

    }

}
