package com.demo.demo.employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import com.demo.demo.activity.Activity;
import com.demo.demo.activity.ActivityController;

public class EmployeeHomePage {

    Logger logger = Logger.getLogger(EmployeeHomePage.class.getName());

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    EmployeeController controller = new EmployeeController();
    private static final Integer END = 100;
    private Integer input = 0;
    private Employee employee;

    public EmployeeHomePage(Employee employee) {
        this.employee = employee;
    }

    public void showHomePage() {
        logger.info("Welcome " + employee.getName() + " " + employee.getRoles());

        logger.info("Select Option: ");
        for (Activity activity : controller.showOptions(employee)) {
            logger.info(activity.getType() + "." + activity.name());
        }
        logger.info("100. Terminate Program");
    }

    public void selectOption() {
        try {
            int option = Integer.parseInt(reader.readLine());
            input = option;
            if (option <= 6) {
                ActivityController activityController = new ActivityController();
                activityController.display(Activity.getActivity(option), employee);
            }
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }

    public Integer getInput() {
        return input;
    }

    public static void main(String[] args) {
        Employee employee = new EmployeeService().getEmployee(101);
        EmployeeHomePage page = new EmployeeHomePage(employee);
        page.showHomePage();
        new Thread(() -> {
            Boolean ended = false;
            while (Boolean.TRUE.equals(ended)) {
                page.selectOption();
                ended = page.input.equals(END);
            }
        }).start();
    }
}
