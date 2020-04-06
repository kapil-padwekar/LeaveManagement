package com.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import com.employee.Employee;
import com.employee.EmployeeHomePage;

public class StartPage {

    static Logger logger = Logger.getLogger(StartPage.class.getName());
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static LoginController loginController = new LoginController();
    private static final Integer END = 100;

    public static void main(String[] args) throws IOException {

        logger.info("Enter Employee ID ");
        int userId = Integer.parseInt(reader.readLine());

        logger.info("Enter Password ");
        String password = reader.readLine();

        Employee user = loginController.authenticate(userId, password);
        if (user != null) {
            EmployeeHomePage homepage = new EmployeeHomePage(user);
            homepage.showHomePage();
            new Thread(() -> {
                Boolean ended = false;
                while (Boolean.TRUE.equals(ended)) {
                    homepage.selectOption();
                    ended = homepage.getInput().equals(END);
                }
            }).start();
        } else {
            logger.info("UserID Or Password Invalid");
        }

    }
}
