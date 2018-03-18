package org.appdirect.challenge.util;


import org.appdirect.challenge.model.SubscriptionModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ValidationImp implements Validation {

    @Autowired
    SubscriptionModelRepository subscriptionModelRepository;

    @Override
    public void validateUniqueUuid(String uuid){
        if(subscriptionModelRepository.findByAccountIdentifier(uuid) != null){
            throw new IllegalArgumentException ();
        }
    }

    @Override
    public void validateExistenceOfAccountId(String accountId){
        if(subscriptionModelRepository.findByAccountIdentifier(accountId) == null){
            throw new ResourceNotFoundException();
        }
    }
}
