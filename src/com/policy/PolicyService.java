package com.policy;

public class PolicyService implements IPolicyService {

    IPolicyRepository repository = new PolicyRepository();

    @Override
    public void submit(Policy policy) {
        repository.submit(policy);
    }

}
