package com.ducanh.simsobackend.repository;

import com.ducanh.simsobackend.entity.SIMCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SIMCardRepository extends JpaRepository<SIMCard, UUID> {
    Optional<SIMCard> findSIMCardsById(UUID id);

    boolean deleteSIMCardById(UUID id);
}