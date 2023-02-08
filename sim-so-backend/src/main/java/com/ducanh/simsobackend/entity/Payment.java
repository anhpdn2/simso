package com.ducanh.simsobackend.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "status")
    private Integer status;

    @Column(name = "payment_time")
    private Timestamp paymentTime;

    @Column(name = "call_customer_time")
    private String callCustomerTime;

    @Column(name = "shipped_time")
    private Instant shippedTime;

    public Instant getShippedTime() {
        return shippedTime;
    }

    public void setShippedTime(Instant shippedTime) {
        this.shippedTime = shippedTime;
    }

    public String getCallCustomerTime() {
        return callCustomerTime;
    }

    public void setCallCustomerTime(String callCustomerTime) {
        this.callCustomerTime = callCustomerTime;
    }

    public Timestamp getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Timestamp paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}