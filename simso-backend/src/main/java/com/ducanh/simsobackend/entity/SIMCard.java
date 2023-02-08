package com.ducanh.simsobackend.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "sim_card")
@Data
public class SIMCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type", length = 30)
    private String type;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "price")
    private Long price;

    @Column(name = "telecom", length = 100)
    private String telecom;

    @Column(name = "fate")
    private Integer fate;

    @Column(name = "point")
    private Integer point;

    @Column(name = "unit_number")
    private Integer unitNumber;

    @Column(name = "description", length = 600)
    private String description;

    @OneToMany(mappedBy="simCard")
    private Set<Invoice> invoices;

}