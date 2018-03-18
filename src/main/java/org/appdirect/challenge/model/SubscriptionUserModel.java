package org.appdirect.challenge.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class SubscriptionUserModel implements Serializable {

    @Id
    @Column
    private String companyUuid;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userSequenceNumber;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String language;

    @Column
    private String email;

    @Column
    private String openId;

    @Column
    private Boolean isCreator;

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private String state;

    @Column
    private String street1;

    @Column
    private String street2;

    @Column
    private String uuid;

    @Column
    private String zip;

    public Long getUserSequenceNumber() {
        return userSequenceNumber;
    }

    public void setUserSequenceNumber(Long userSequenceNumber) {
        this.userSequenceNumber = userSequenceNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyUuid() {
        return companyUuid;
    }

    public void setCompanyUuid(String companyUuid) {
        this.companyUuid = companyUuid;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Boolean getCreator() {
        return isCreator;
    }

    public void setCreator(Boolean creator) {
        isCreator = creator;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
