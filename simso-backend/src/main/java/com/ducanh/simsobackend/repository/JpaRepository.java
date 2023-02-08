package com.ducanh.simsobackend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JpaRepository {
    @Autowired
    public InvoiceRepository invoiceRepository;
    @Autowired
    public PaymentRepository paymentRepository;
    @Autowired
    public SIMCardRepository simCardRepository;
}
