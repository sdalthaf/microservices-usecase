package com.codevthme.HospitalsOnPanel;

import com.codevthme.HospitalsOnPanel.entity.Hospital;
import com.codevthme.HospitalsOnPanel.repository.HospitalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HospitalService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HospitalService.class);

    @Autowired
    private HospitalRepository hospitalRepository;

    public Hospital registerHospital(Hospital hospital) {
        LOGGER.info("Registering the hospital.");
        return hospitalRepository.save(hospital);
    }

    public Optional<Hospital> getHospitalById(Long id) {
        return hospitalRepository.findById(id);
    }

    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

}
