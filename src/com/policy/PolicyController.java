package com.policy;

public class PolicyController {

    IPolicyService service = new PolicyService();

    public void submit(Policy policy) {
        service.submit(policy);
    }
}
