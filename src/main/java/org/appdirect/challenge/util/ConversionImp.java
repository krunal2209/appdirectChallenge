package org.appdirect.challenge.util;

import org.appdirect.challenge.dto.Payload;
import org.appdirect.challenge.dto.Subscription;
import org.appdirect.challenge.dto.User;
import org.appdirect.challenge.model.OrderItemModel;
import org.appdirect.challenge.model.SubscriptionModel;
import org.appdirect.challenge.model.SubscriptionUserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;


@Component
public class ConversionImp implements Conversion {

    protected Logger logger = LoggerFactory.getLogger(ConversionImp.class);

    @Override
    public void daoToEntityConversion(Subscription subscription, SubscriptionModel subscriptionModel) {
        List<SubscriptionUserModel> subscriptionUserModelList = new ArrayList<>();

        subscriptionModel.setReturnUrl(subscription.getReturnUrl());

        //MarketPlace data
        if(subscription.getMarketPlace() != null){
            subscriptionModel.setBaseUrl(subscription.getMarketPlace().getBaseUrl());
            subscriptionModel.setPartner(subscription.getMarketPlace().getPartner());
        }

        //map creator data
        if(subscription.getCreator() != null){
            SubscriptionUserModel subscriptionUserModel = new SubscriptionUserModel();
            if(subscription.getPayload().getCompany() != null)
                subscriptionUserModel.setCompanyUuid(subscription.getPayload().getCompany().getUuid());
            else
                subscriptionUserModel.setCompanyUuid(subscriptionModel.getCompanyUuid());
            this.mapUserData(subscription.getCreator(), subscriptionUserModel);

            subscriptionUserModel.setCreator(true);

            subscriptionUserModelList.add(subscriptionUserModel);
            subscriptionModel.setSubscriptionUsers(subscriptionUserModelList);
        }

        //map Payload
        if(subscription.getPayload() != null){
            //map User
            if(subscription.getPayload().getUser() != null){
                SubscriptionUserModel subscriptionUserModel = new SubscriptionUserModel();
                if(subscription.getPayload().getCompany() != null)
                   subscriptionUserModel.setCompanyUuid(subscription.getPayload().getCompany().getUuid());
                else
                    subscriptionUserModel.setCompanyUuid(subscriptionModel.getCompanyUuid());
                this.mapUserData(subscription.getPayload().getUser(), subscriptionUserModel);

                subscriptionUserModel.setCreator(true);

                subscriptionUserModelList.add(subscriptionUserModel);
                subscriptionModel.setSubscriptionUsers(subscriptionUserModelList);
            }

            this.mapPayload(subscription.getPayload(),subscriptionModel);
        }

    }

    @Override
    public void mapUserData(User user, SubscriptionUserModel subscriptionUserModel){
        subscriptionUserModel.setEmail(user.getEmail());
        subscriptionUserModel.setFirstName(user.getFirstName());
        subscriptionUserModel.setLanguage(user.getLanguage());
        subscriptionUserModel.setLastName(user.getLastName());
        subscriptionUserModel.setOpenId(user.getOpenId());
        subscriptionUserModel.setUuid(user.getUuid());

        //Address
        if(user.getAddress()!=null){
            subscriptionUserModel.setCity(user.getAddress().getCity());
            subscriptionUserModel.setCountry(user.getAddress().getCountry());
            subscriptionUserModel.setState(user.getAddress().getState());
            subscriptionUserModel.setStreet1(user.getAddress().getStreet1());
            subscriptionUserModel.setStreet2(user.getAddress().getStreet2());
            subscriptionUserModel.setZip(user.getAddress().getZip());
        }
    }

    private void mapPayload(Payload payload, SubscriptionModel subscriptionModel){

        //Payload-> Company
        if(payload.getCompany()!= null){
            subscriptionModel.setAccountIdentifier(payload.getCompany().getUuid());
            subscriptionModel.setCompanyUuid(payload.getCompany().getUuid());
            subscriptionModel.setComapnyCountry(payload.getCompany().getCountry());
            subscriptionModel.setComapnyEmail(payload.getCompany().getEmail());
            subscriptionModel.setComapnyName(payload.getCompany().getName());
            subscriptionModel.setComapnyPhoneNumber(payload.getCompany().getPhoneNumber());
            subscriptionModel.setComapnyWebsite(payload.getCompany().getWebsite());
            subscriptionModel.setCompanyExternalId(payload.getCompany().getExternalId());
        }

        //Payload->order
        if(payload.getOrder() != null){
            subscriptionModel.setEditionCode(payload.getOrder().getEditionCode());
            subscriptionModel.setPricingDuration(payload.getOrder().getPricingDuration());

            //Order->items
            if(payload.getOrder().getItems() != null){
                subscriptionModel.setItems(payload.getOrder().getItems().stream().map(item -> {
                    OrderItemModel orderItemModel = new OrderItemModel();
                    orderItemModel.setCompanyUuid(subscriptionModel.getCompanyUuid());
                    orderItemModel.setQuantity(item.getQuantity());
                    orderItemModel.setUnit(item.getUnit());
                    return orderItemModel;
                }).collect(Collectors.toList()));

            }
        }

    }
}
