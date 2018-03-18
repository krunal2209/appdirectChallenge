package org.appdirect.challenge.controller;

import org.appdirect.challenge.Service.UserService;
import org.appdirect.challenge.api.UserApi;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class UserController implements UserApi{

    protected Logger logger = LoggerFactory.getLogger(SubscriptionController.class);

    @Qualifier("userServiceImp")
    @Autowired
    private UserService userService;

    @Autowired
    private ConversionImp conversion;

    @Autowired
    private SubscriptionModelRepository subscriptionModelRepository;

    @Override
    public ResponseEntity<Response> userAssignUserGet(String eventUrl) {
        logger.info("Assign User EvenURL: {}",eventUrl);

        Response assignUserResponse = null;
        try{
            assignUserResponse = userService.assignUser(eventUrl);
        } catch (ResourceNotFoundException e){
            assignUserResponse.setErrorCode(Response.ErrorCodeEnum.ACCOUNT_NOT_FOUND);
            assignUserResponse.setMessage("Account not found.");
            assignUserResponse.setSuccess(false);
        }
        catch (Exception e){
            assignUserResponse.setErrorCode(Response.ErrorCodeEnum.UNKNOWN_ERROR);
            assignUserResponse.setSuccess(false);
        }

        return new ResponseEntity<>(assignUserResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> userUnassignUserGet(String eventUrl) {
        logger.info("Unassign User EvenURL: {}",eventUrl);

        Response unAssignUserResponse = null;
        try{
            unAssignUserResponse = userService.unassignUser(eventUrl);
        } catch (ResourceNotFoundException e){
            unAssignUserResponse.setErrorCode(Response.ErrorCodeEnum.ACCOUNT_NOT_FOUND);
            unAssignUserResponse.setMessage("Account not found.");
            unAssignUserResponse.setSuccess(false);
        }
        catch (Exception e){
            unAssignUserResponse.setErrorCode(Response.ErrorCodeEnum.UNKNOWN_ERROR);
            unAssignUserResponse.setSuccess(false);
        }

        return new ResponseEntity<>(unAssignUserResponse, HttpStatus.OK);
    }
}
