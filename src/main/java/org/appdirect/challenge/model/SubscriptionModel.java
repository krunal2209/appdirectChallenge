package org.appdirect.challenge.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class SubscriptionModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, nullable = false)
    private String companyUuid;

    @Column(unique = true, nullable = false)
    private String accountIdentifier;

    @Column
    private String companyExternalId;

    @Column
    private String comapnyName;

    @Column
    private String comapnyEmail;

    @Column
    private String comapnyPhoneNumber;

    @Column
    private String comapnyWebsite;

    @Column
    private String comapnyCountry;

    @Column
    private String baseUrl;

    @Column
    private String partner;

    @Column
    private String returnUrl;

    @Column
    private String editionCode;

    @Column
    private String pricingDuration;

    @Column
    private String state;

    @JoinColumn(name = "companyUuid", referencedColumnName = "companyUuid", nullable = false, insertable=false, updatable=false)
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<OrderItemModel> items;

    @JoinColumn(name = "companyUuid", referencedColumnName = "companyUuid", nullable = false, insertable=false, updatable=false)
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<SubscriptionUserModel> subscriptionUsers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyUuid() {
        return companyUuid;
    }

    public void setCompanyUuid(String companyUuid) {
        this.companyUuid = companyUuid;
    }

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public String getCompanyExternalId() {
        return companyExternalId;
    }

    public void setCompanyExternalId(String companyExternalId) {
        this.companyExternalId = companyExternalId;
    }

    public String getComapnyName() {
        return comapnyName;
    }

    public void setComapnyName(String comapnyName) {
        this.comapnyName = comapnyName;
    }

    public String getComapnyEmail() {
        return comapnyEmail;
    }

    public void setComapnyEmail(String comapnyEmail) {
        this.comapnyEmail = comapnyEmail;
    }

    public String getComapnyPhoneNumber() {
        return comapnyPhoneNumber;
    }

    public void setComapnyPhoneNumber(String comapnyPhoneNumber) {
        this.comapnyPhoneNumber = comapnyPhoneNumber;
    }

    public String getComapnyWebsite() {
        return comapnyWebsite;
    }

    public void setComapnyWebsite(String comapnyWebsite) {
        this.comapnyWebsite = comapnyWebsite;
    }

    public String getComapnyCountry() {
        return comapnyCountry;
    }

    public void setComapnyCountry(String comapnyCountry) {
        this.comapnyCountry = comapnyCountry;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getEditionCode() {
        return editionCode;
    }

    public void setEditionCode(String editionCode) {
        this.editionCode = editionCode;
    }

    public String getPricingDuration() {
        return pricingDuration;
    }

    public void setPricingDuration(String pricingDuration) {
        this.pricingDuration = pricingDuration;
    }

    public List<OrderItemModel> getItems() {
        return items;
    }

    public void setItems(List<OrderItemModel> items) {
        this.items = items;
    }

    public List<SubscriptionUserModel> getSubscriptionUsers() {
        return subscriptionUsers;
    }

    public void setSubscriptionUsers(List<SubscriptionUserModel> subscriptionUsers) {
        this.subscriptionUsers = subscriptionUsers;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
