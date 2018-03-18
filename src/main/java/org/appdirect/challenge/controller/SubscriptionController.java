package org.appdirect.challenge.controller;

import org.appdirect.challenge.Service.SubscriptionService;
import org.appdirect.challenge.api.SubscriptionApi;
import org.appdirect.challenge.dto.Response;
import org.appdirect.challenge.model.SubscriptionModelRepository;
import org.appdirect.challenge.util.ConversionImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class SubscriptionController implements SubscriptionApi {

    protected Logger logger = LoggerFactory.getLogger(SubscriptionController.class);

    @Qualifier("subscriptionServiceImp")
    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private ConversionImp conversion;

    @Autowired
    private SubscriptionModelRepository subscriptionModelRepository;

    @Override
    public ResponseEntity<Response> subscriptionCancelGet(String eventUrl) {
        logger.info("Cancel Subscription EvenURL: {}",eventUrl);
        Response cancelResponse = null;
        try{
            cancelResponse = subscriptionService.cancelSubscription(eventUrl);
        } catch (ResourceNotFoundException e){
            cancelResponse.setErrorCode(Response.ErrorCodeEnum.ACCOUNT_NOT_FOUND);
            cancelResponse.setMessage("Account not found.");
            cancelResponse.setSuccess(false);
        }
        catch (Exception e){
            cancelResponse.setErrorCode(Response.ErrorCodeEnum.UNKNOWN_ERROR);
            cancelResponse.setSuccess(false);
        }

        return new ResponseEntity<>(cancelResponse,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> subscriptionCreateGet(String eventUrl) {
        logger.info("Create Subscription EvenURL: {}",eventUrl);
        Response createResponse = null;

        try{
            createResponse = subscriptionService.createSubscription(eventUrl);
        } catch (IllegalArgumentException i){
            createResponse.setErrorCode(Response.ErrorCodeEnum.FORBIDDEN);
            createResponse.setMessage("UUID is not unique.");
            createResponse.setSuccess(false);
        }
        catch (Exception e){
            createResponse.setErrorCode(Response.ErrorCodeEnum.UNKNOWN_ERROR);
            createResponse.setSuccess(false);
        }

        return new ResponseEntity<>(createResponse,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> subscriptionChangeGet(String eventUrl) {
        logger.info("Change Subscription EvenURL: {}",eventUrl);
        Response changeResponse = null;
        try{
            changeResponse = subscriptionService.changeSubscription(eventUrl);
        } catch (ResourceNotFoundException e){
            changeResponse.setErrorCode(Response.ErrorCodeEnum.ACCOUNT_NOT_FOUND);
            changeResponse.setMessage("Account not found.");
            changeResponse.setSuccess(false);
        }
        catch (Exception e){
            changeResponse.setErrorCode(Response.ErrorCodeEnum.UNKNOWN_ERROR);
            changeResponse.setSuccess(false);
        }

        return new ResponseEntity<>(changeResponse,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> subscriptionNotificationGet(String eventUrl) {
        Response notificationResponse = null;
        try{
            notificationResponse = subscriptionService.notifySubscription(eventUrl);
        } catch (ResourceNotFoundException e){
            notificationResponse.setErrorCode(Response.ErrorCodeEnum.ACCOUNT_NOT_FOUND);
            notificationResponse.setMessage("Account not found.");
            notificationResponse.setSuccess(false);
        }

        return new ResponseEntity<>(notificationResponse,HttpStatus.OK);
    }
}
