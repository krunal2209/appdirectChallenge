package org.appdirect.challenge.Service;

import org.appdirect.challenge.dto.Response;
import org.appdirect.challenge.dto.Subscription;
import org.appdirect.challenge.model.SubscriptionModel;
import org.appdirect.challenge.model.SubscriptionModelRepository;
import org.appdirect.challenge.model.SubscriptionUserModel;
import org.appdirect.challenge.util.Conversion;
import org.appdirect.challenge.util.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private SubscriptionService subscriptionService;

    protected Logger logger = LoggerFactory.getLogger(SubscriptionServiceImp.class);

    @Autowired
    private SubscriptionModelRepository subscriptionModelRepository;

    @Autowired
    private Validation validation;

    @Autowired
    private Conversion conversion;

    @Override
    public Response assignUser(String eventUrl) {
        Response assignUserResponse = new Response();
        Subscription subscription = new Subscription();

        subscription = subscriptionService.getEventData(eventUrl);
        logger.info("Assign User info",subscription);

        if(!subscriptionService.isPingTest(subscription)){
            //Validate existence of the account
            validation.validateExistenceOfAccountId(subscription.getPayload().getAccount().getAccountIdentifier());

            SubscriptionModel subscriptionModel = subscriptionModelRepository.findByAccountIdentifier(subscription.getPayload().getAccount().getAccountIdentifier());

            SubscriptionUserModel subscriptionUserModel = new SubscriptionUserModel();
            subscriptionUserModel.setCompanyUuid(subscriptionModel.getCompanyUuid());
            conversion.mapUserData(subscription.getPayload().getUser(), subscriptionUserModel);

            subscriptionModelRepository.save(subscriptionModel);

            logger.info("Successfully assigned user to subscription accountID: {}", subscription.getPayload().getAccount().getAccountIdentifier());
        }

        assignUserResponse.setSuccess(true);

        return assignUserResponse;
    }

    @Override
    public Response unassignUser(String eventUrl) {
        Response unassignUserResponse = new Response();
        Subscription subscription = new Subscription();

        subscription = subscriptionService.getEventData(eventUrl);
        logger.info("Unassign User info",subscription);

        if(!subscriptionService.isPingTest(subscription)){
            //Validate existence of the account
            validation.validateExistenceOfAccountId(subscription.getPayload().getAccount().getAccountIdentifier());

            SubscriptionModel subscriptionModel = subscriptionModelRepository.findByAccountIdentifier(subscription.getPayload().getAccount().getAccountIdentifier());

            SubscriptionUserModel subscriptionUserModel = new SubscriptionUserModel();
            subscriptionUserModel.setCompanyUuid(subscriptionModel.getCompanyUuid());
            conversion.mapUserData(subscription.getPayload().getUser(), subscriptionUserModel);

            subscriptionModelRepository.save(subscriptionModel);

            logger.info("Successfully unassigned user to subscription accountID: {}", subscription.getPayload().getAccount().getAccountIdentifier());
        }

        unassignUserResponse.setSuccess(true);

        return unassignUserResponse;
    }


}
