package org.appdirect.challenge.Service;

import org.appdirect.challenge.dto.Response;
import org.appdirect.challenge.dto.Subscription;

public interface SubscriptionService {
    public Subscription getEventData(String eventUrl);
    public Response createSubscription(String eventUrl);
    public Response cancelSubscription(String eventUrl);
    public Response changeSubscription(String eventUrl);
    public Response notifySubscription(String eventUrl);
    public boolean isPingTest(Subscription subscription);
}
