package com.demo.demo.leave;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

public class Leave {

    private Integer id;
    private LeaveType leaveType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;

    public Leave(LeaveType leaveType, LocalDate startDate, LocalDate endDate, String reason) {
        this.id = new Random().nextInt(100);
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
    }

    public Integer getId() {
        return id;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getNoOfDays() {
        Period period = Period.between(startDate, endDate);
        return period.getDays();
    }

    @Override
    public String toString() {
        return "Leave [id=" + id + ", leaveType=" + leaveType + ", startDate=" + startDate + ", endDate=" + endDate
                + ", reason=" + reason + "]";
    }

}
