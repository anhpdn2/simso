package com.ducanh.simsobackend.controller;

import com.ducanh.simsobackend.dto.SimCardDTO;
import com.ducanh.simsobackend.entity.SIMCard;
import com.ducanh.simsobackend.service.SimCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/sim-card")
@Slf4j
public class SimCardController {
    @Autowired
    private SimCardService simCardService;
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<SIMCard> findOneSim(@PathVariable String id) {
        System.out.println("id: " + id);
        return ResponseEntity.ok(simCardService.findOneSimCard(id));
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
    public ResponseEntity<Boolean> updateSim(@RequestBody String id) {

        return ResponseEntity.ok(simCardService.deleteSim(id));
    }
}
