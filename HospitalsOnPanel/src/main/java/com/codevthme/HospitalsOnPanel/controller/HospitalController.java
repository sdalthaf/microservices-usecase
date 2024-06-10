package com.codevthme.HospitalsOnPanel.controller;

import com.codevthme.HospitalsOnPanel.HospitalService;
import com.codevthme.HospitalsOnPanel.entity.Hospital;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    private static final Logger LOGGER = LoggerFactory.getLogger(HospitalController.class);

    @PostMapping
    public ResponseEntity<Hospital> registerHospital(@RequestBody Hospital hospital) {
        LOGGER.info("Received hospital enrollment request");
        Hospital savedHospital = hospitalService.registerHospital(hospital);
        LOGGER.info("Successfully Registered the hospital.");
        return ResponseEntity.ok(savedHospital);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospital> getHospitalById(@PathVariable Long id) {
        LOGGER.info("Fetching Hospital details with ID "+id);
        return hospitalService.getHospitalById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Hospital>> getAllHospitals() {
        LOGGER.info("Fetching All Hospitals!!");
        List<Hospital> hospitals = hospitalService.getAllHospitals();
        return ResponseEntity.ok(hospitals);
    }
}
