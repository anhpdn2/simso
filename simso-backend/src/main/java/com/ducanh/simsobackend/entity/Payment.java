package com.ducanh.simsobackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "payment")
@Data
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

    @OneToOne(mappedBy = "payment", orphanRemoval = true)
    private Invoice invoice;

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

}