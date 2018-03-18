package org.appdirect.challenge.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OrderItemModel implements Serializable{

    @Id
    private String companyUuid;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderItemSequenceNumber;

    @Column
    private Integer quantity;

    @Column
    private String unit;

    public String getCompanyUuid() {
        return companyUuid;
    }

    public void setCompanyUuid(String companyUuid) {
        this.companyUuid = companyUuid;
    }

    public Long getOrderItemSequenceNumber() {
        return orderItemSequenceNumber;
    }

    public void setOrderItemSequenceNumber(Long orderItemSequenceNumber) {
        this.orderItemSequenceNumber = orderItemSequenceNumber;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
