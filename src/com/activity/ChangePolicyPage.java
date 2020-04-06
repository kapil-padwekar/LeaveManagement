package com.activity;

import java.util.logging.Logger;

import com.policy.Policy;
import com.policy.PolicyController;

public class ChangePolicyPage implements IActivityPage {

    Logger logger = Logger.getLogger(ChangePolicyPage.class.getName());

    PolicyController controller = new PolicyController();

    @Override
    public void display() {
        logger.info("Change Policy Page");
        controller.submit(new Policy());
    }

}
