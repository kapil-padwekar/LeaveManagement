package com.demo.demo.activity;

import java.util.Arrays;
import java.util.List;

public class ActivityRepository {

    private static final List<Activity> HR_OPTIONS = Arrays.asList(Activity.VIEWLEAVE, Activity.APPLYLEAVE,
            Activity.UPDATELEAVE, Activity.CANCELLEAVE, Activity.CHANGEPOLICY);
    private static final List<Activity> SUPERVISOR_OPTIONS = Arrays.asList(Activity.VIEWLEAVE, Activity.APPLYLEAVE,
            Activity.UPDATELEAVE, Activity.CANCELLEAVE, Activity.VIEWALLLEAVE);
    private static final List<Activity> EMPLOYEE_OPTIONS = Arrays.asList(Activity.VIEWLEAVE, Activity.APPLYLEAVE,
            Activity.UPDATELEAVE, Activity.CANCELLEAVE);
    private static final List<Activity> HR_SUPERVISOR_OPTIONS = Arrays.asList(Activity.VIEWLEAVE, Activity.APPLYLEAVE,
            Activity.UPDATELEAVE, Activity.CANCELLEAVE, Activity.VIEWALLLEAVE, Activity.CHANGEPOLICY);

    public List<Activity> getEmployeeOptions() {
        return EMPLOYEE_OPTIONS;
    }

    public List<Activity> getSupervisorOptions() {
        return SUPERVISOR_OPTIONS;
    }

    public List<Activity> getHROptions() {
        return HR_OPTIONS;
    }

    public List<Activity> getHRSupervisorOptions() {
        return HR_SUPERVISOR_OPTIONS;
    }

}
