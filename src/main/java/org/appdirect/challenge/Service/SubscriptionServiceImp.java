package org.appdirect.challenge.Service;

import org.appdirect.challenge.dto.Notice;
import org.appdirect.challenge.dto.Response;
import org.appdirect.challenge.dto.Subscription;
import org.appdirect.challenge.model.SubscriptionModel;
import org.appdirect.challenge.model.SubscriptionModelRepository;
import org.appdirect.challenge.util.Conversion;
import org.appdirect.challenge.util.ConversionImp;
import org.appdirect.challenge.util.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth.consumer.ProtectedResourceDetails;
import org.springframework.security.oauth.consumer.client.OAuthRestTemplate;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImp implements SubscriptionService {


    protected Logger logger = LoggerFactory.getLogger(SubscriptionServiceImp.class);

    @Autowired
    @Qualifier("protectedResource")
    private ProtectedResourceDetails protectedResourceDetails;

    @Autowired
    private Conversion conversion;

    @Autowired
    private SubscriptionModelRepository subscriptionModelRepository;

    @Autowired
    private Validation validation;

    @Override
    public Response createSubscription(String eventUrl) {
        Response createResponse = new Response();
        Subscription subscription = new Subscription();

        subscription = this.getEventData(eventUrl);
        logger.info("Create Subscription info",subscription);

        if(!this.isPingTest(subscription)){
            SubscriptionModel subscriptionModel = new SubscriptionModel();

            //Validate Uniqueness of the UUID
            validation.validateUniqueUuid(subscription.getPayload().getCompany().getUuid());

            conversion.daoToEntityConversion(subscription,subscriptionModel);
            subscriptionModelRepository.save(subscriptionModel);

            logger.info("Successfully create subscription with accountID: {}", subscription.getPayload().getCompany().getUuid());
        }

        createResponse.setSuccess(true);
        createResponse.setAccountIdentifier(subscription.getPayload().getCompany().getUuid());

        return createResponse;
    }

    @Override
    public Response cancelSubscription(String eventUrl) {
        Subscription subscription = new Subscription();
        subscription = this.getEventData(eventUrl);

        logger.info("Cancel Subscription info",subscription);

        if(!this.isPingTest(subscription)){
            //Validate existence of the account
            validation.validateExistenceOfAccountId(subscription.getPayload().getAccount().getAccountIdentifier());

            SubscriptionModel subscriptionModel = subscriptionModelRepository.findByAccountIdentifier(subscription.getPayload().getAccount().getAccountIdentifier());
            subscriptionModelRepository.delete(subscriptionModel);

            logger.info("Successfully canceled subscription with accountID: {}", subscription.getPayload().getAccount().getAccountIdentifier());
        }

        Response cancelResponse = new Response();
        cancelResponse.setSuccess(true);
        return cancelResponse;
    }

    @Override
    public Response changeSubscription(String eventUrl) {
        Subscription subscription = new Subscription();
        subscription = this.getEventData(eventUrl);

        logger.info("Change Subscription info",subscription);

        if(!this.isPingTest(subscription)){
            SubscriptionModel subscriptionModel = new SubscriptionModel();
            subscriptionModel =  subscriptionModelRepository.findByAccountIdentifier(subscription.getPayload().getAccount().getAccountIdentifier());

            conversion.daoToEntityConversion(subscription,subscriptionModel);
            subscriptionModelRepository.save(subscriptionModel);

            logger.info("Successfully changed subscription with accountID: {}", subscription.getPayload().getAccount().getAccountIdentifier());
        }


        Response changeResponse = new Response();
        changeResponse.setSuccess(true);
        return changeResponse;
    }

    @Override
    public Subscription getEventData(String eventUrl) {
        OAuthRestTemplate oAuthRestTemplate = new OAuthRestTemplate(protectedResourceDetails);
        return oAuthRestTemplate.getForObject(eventUrl, Subscription.class);
    }

    @Override
    public boolean isPingTest(Subscription subscription){
        if(Subscription.FlagEnum.STATELESS.equals(subscription.getFlag())){
            logger.info("Ping Test");
            return true;
        }
        else{
            logger.info("Dev test");
            return false;
        }

    }

    @Override
    public Response notifySubscription(String eventUrl) {
        Subscription subscription = new Subscription();
        subscription = this.getEventData(eventUrl);

        logger.info("Notification Subscription info",subscription);

        if(!this.isPingTest(subscription)){
            //Validate existence of the account
            validation.validateExistenceOfAccountId(subscription.getPayload().getAccount().getAccountIdentifier());

            Notice notice = subscription.getPayload().getNotice();

            SubscriptionModel subscriptionModel = new SubscriptionModel();
            subscriptionModel =  subscriptionModelRepository.findByAccountIdentifier(subscription.getPayload().getAccount().getAccountIdentifier());

            if(notice.getType().equals(Notice.TypeEnum.CLOSED)) {
                subscriptionModelRepository.delete(subscriptionModel);
                logger.info("Deleted closed subscription");
            }
            else {
                subscriptionModel.setState(subscription.getPayload().getAccount().getStatus());
                subscriptionModelRepository.save(subscriptionModel);
            }

            logger.info("Successfully changed Notification with accountID: {}", subscription.getPayload().getAccount().getAccountIdentifier());
        }

        Response changeResponse = new Response();
        changeResponse.setSuccess(true);
        return changeResponse;
    }
}
