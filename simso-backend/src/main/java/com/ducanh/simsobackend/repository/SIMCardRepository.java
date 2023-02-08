package com.ducanh.simsobackend.repository;

import com.ducanh.simsobackend.entity.SIMCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SIMCardRepository extends JpaRepository<SIMCard, Long> {
    Optional<SIMCard> findSIMCardsById(Long id);

    boolean deleteSIMCardById(Long id);
}