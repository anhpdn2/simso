package com.ducanh.simsobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimCardDTO {
    private String type;

    private String phoneNumber;

    private Long price;

    private String telecom;

    private Integer fate;

    private Integer point;

    private Integer unitNumber;

    private String description;
}
