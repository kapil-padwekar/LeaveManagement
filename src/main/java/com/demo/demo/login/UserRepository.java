package com.demo.demo.login;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private static Map<Integer, String> userDetails = new HashMap<>();

    static {
        userDetails.put(101, "pass1");
        userDetails.put(102, "pass2");
        userDetails.put(103, "pass3");
        userDetails.put(104, "pass4");
    }

    public Map<Integer, String> getUserDetails() {
        return userDetails;
    }

    public Boolean userExists(Integer userId) {
        return userDetails.containsKey(userId);
    }

    public String getPassword(Integer userId) {
        return userDetails.getOrDefault(userId, "NF");
    }

}
