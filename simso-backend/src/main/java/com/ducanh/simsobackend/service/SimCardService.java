package com.ducanh.simsobackend.service;

import com.ducanh.simsobackend.entity.SIMCard;

import java.util.UUID;

public interface SimCardService {
    SIMCard findOneSimCard(Long id);
    SIMCard saveSim(SIMCard simCard);
    boolean deleteSim(Long id);
}
