package com.ducanh.simsobackend.controller;

import com.ducanh.simsobackend.dto.SimCardDTO;
import com.ducanh.simsobackend.entity.SIMCard;
import com.ducanh.simsobackend.service.SimCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@RestController
@RequestMapping("/api/sim-card")
@Slf4j
public class SimCardController {
    @Autowired
    private SimCardService simCardService;

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<SIMCard> findOneSim(@PathVariable Long id) {
        return ResponseEntity.ok(simCardService.findOneSimCard(id));
    }

    @KafkaListener(topics = "demo", groupId = "group-id")
    public void listen(String message) {
        System.out.println("Received Message in group - group-id: " + message);
    }

    @PostMapping
    public ResponseEntity<SIMCard> saveSim(@RequestBody SIMCard sim) {
        return ResponseEntity.ok(simCardService.saveSim(sim));
    }

    @PutMapping
    public ResponseEntity<SIMCard> updateSim(@RequestBody SIMCard sim) {

        return ResponseEntity.ok(simCardService.saveSim(sim));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> updateSim(@RequestBody Long id) {

        return ResponseEntity.ok(simCardService.deleteSim(id));
    }
}
