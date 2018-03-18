package org.appdirect.challenge.util;

import org.appdirect.challenge.dto.Subscription;
import org.appdirect.challenge.dto.User;
import org.appdirect.challenge.model.SubscriptionModel;
import org.appdirect.challenge.model.SubscriptionUserModel;
import org.springframework.stereotype.Service;

@Service
public interface Conversion {
    public void daoToEntityConversion(Subscription subscription, SubscriptionModel subscriptionModel);
    public void mapUserData(User user, SubscriptionUserModel subscriptionUserModel);
}
