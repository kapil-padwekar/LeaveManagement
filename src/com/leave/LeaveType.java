package com.leave;

public enum LeaveType {
    CASUAL(1), SICK(2), EARNED(3), LWP(4);

    private Integer type;

    private LeaveType(Integer leaveType) {
        this.type = leaveType;
    }

    public static LeaveType getLeaveType(int type) {
        for (LeaveType leaveType : values()) {
            if (leaveType.type == type) {
                return leaveType;
            }
        }
        return null;
    }

    public int getType() {
        return this.type;
    }
}
