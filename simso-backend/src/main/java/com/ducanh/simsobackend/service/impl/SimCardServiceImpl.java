package com.ducanh.simsobackend.service.impl;


import com.ducanh.simsobackend.entity.SIMCard;
import com.ducanh.simsobackend.repository.JpaRepository;
import com.ducanh.simsobackend.service.SimCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SimCardServiceImpl implements SimCardService {
    @Autowired
    JpaRepository jpaRepository;

    @Override
    public SIMCard findOneSimCard(Long id) {
        return jpaRepository.simCardRepository.findSIMCardsById(id).orElseThrow();
    }

    @Override
    public SIMCard saveSim(SIMCard simCard) {
        return jpaRepository.simCardRepository.save(simCard);
    }

    @Override
    public boolean deleteSim(Long id) {
        return jpaRepository.simCardRepository.deleteSIMCardById(id);
    }
}
