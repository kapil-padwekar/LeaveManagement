package com.activity;

public enum Activity {
    VIEWLEAVE(1), APPLYLEAVE(2), UPDATELEAVE(3), CANCELLEAVE(4), VIEWALLLEAVE(5), CHANGEPOLICY(6),;

    private int type;

    private Activity(int activityType) {
        this.type = activityType;
    }

    public static Activity getActivity(int type) {
        for (Activity activity : values()) {
            if (activity.type == type) {
                return activity;
            }
        }
        return null;
    }

    public int getType() {
        return this.type;
    }
}
