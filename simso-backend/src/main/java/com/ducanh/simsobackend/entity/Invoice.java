package com.ducanh.simsobackend.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "invoice")
@Data
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "sim_method")
    private Integer sim_method;

    @Column(name = "ship_method")
    private Integer ship_method;

    @Column(name = "mail_status")
    private Integer mailStatus;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name="sim_id", nullable=false)
    private SIMCard simCard;
}