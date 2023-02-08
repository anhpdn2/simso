package com.ducanh.simsobackend.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

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

    public Integer getShip_method() {
        return ship_method;
    }

    public void setShip_method(Integer ship_method) {
        this.ship_method = ship_method;
    }

    public Integer getSim_method() {
        return sim_method;
    }

    public void setSim_method(Integer sim_method) {
        this.sim_method = sim_method;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getMailStatus() {
        return mailStatus;
    }

    public void setMailStatus(Integer mailStatus) {
        this.mailStatus = mailStatus;
    }
}