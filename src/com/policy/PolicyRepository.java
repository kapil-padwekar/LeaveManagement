package com.policy;

import java.util.logging.Logger;

public class PolicyRepository implements IPolicyRepository {

    Logger logger = Logger.getLogger(PolicyRepository.class.getName());

    @Override
    public void submit(Policy policy) {
        logger.info("Policy Submitted");
    }

}
