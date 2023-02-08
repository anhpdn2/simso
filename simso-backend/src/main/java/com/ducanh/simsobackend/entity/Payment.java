package com.ducanh.simsobackend.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "payment")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private Integer status;

    @Column(name = "payment_time")
    private Instant paymentTime;

    @Column(name = "call_customer_time")
    private Instant callCustomerTime;

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