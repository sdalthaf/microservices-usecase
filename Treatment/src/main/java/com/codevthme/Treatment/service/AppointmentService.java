package com.codevthme.Treatment.service;

import com.codevthme.Treatment.entity.Appointment;
import com.codevthme.Treatment.entity.Hospital;
import com.codevthme.Treatment.repository.AppointmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class AppointmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentService.class);

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private AppointmentRepository appointmentRepository;
    public Optional<Appointment> bookAppointment(Appointment appointment) {
        LOGGER.info("Validating the Appointment request");
        Hospital hospital = validateAppointment(appointment);
        if(hospital != null && appointment.getHospitalId() == hospital.getId()){
            LOGGER.info("Booking the Appointment!!");
            return Optional.of(appointmentRepository.save(appointment));
        }

        return Optional.empty();
    }

    private Hospital validateAppointment(Appointment appointment) {
        LOGGER.info("Fetching the hospital details from HospitalOnPanel Service!!");
        Hospital hospital = restTemplate.getForObject("http://hospitals-on-panel/hospitals/"+appointment.getHospitalId(), Hospital.class);
        if (hospital!=null){
            LOGGER.info("Successfully fetched the hospital details!!!");
            return hospital;
        }
        LOGGER.error("Failed to fetch the hospital details!!!");
        return hospital;
    }
}
