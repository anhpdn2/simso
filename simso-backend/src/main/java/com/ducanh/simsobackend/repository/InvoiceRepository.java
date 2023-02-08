package com.ducanh.simsobackend.repository;

import com.ducanh.simsobackend.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}