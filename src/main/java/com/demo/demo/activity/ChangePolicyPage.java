package com.demo.demo.activity;

import java.util.logging.Logger;

import com.demo.demo.policy.Policy;
import com.demo.demo.policy.PolicyController;

public class ChangePolicyPage implements IActivityPage {

    Logger logger = Logger.getLogger(ChangePolicyPage.class.getName());

    PolicyController controller = new PolicyController();

    @Override
    public void display() {
        logger.info("Change Policy Page");
        controller.submit(new Policy());
    }

}
