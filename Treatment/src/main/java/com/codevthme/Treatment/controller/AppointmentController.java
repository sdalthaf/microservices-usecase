package com.codevthme.Treatment.controller;

import com.codevthme.Treatment.entity.Appointment;
import com.codevthme.Treatment.entity.AppointmentResponse;
import com.codevthme.Treatment.service.AppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentController.class);

    @PostMapping
    public ResponseEntity<AppointmentResponse> bookAppointment(@RequestBody Appointment appointment){
        LOGGER.info("Appointment Request received for "+appointment.getPatientName());
        Optional<Appointment> bookedeAppointment = appointmentService.bookAppointment(appointment);

        if(bookedeAppointment.isEmpty()){
            LOGGER.error("Failed to book the appointment!!");

            return ResponseEntity.notFound().build();
        } else{

            LOGGER.info("Appointment Booked Successfully!!");
            return ResponseEntity
                    .ok(new AppointmentResponse(bookedeAppointment.get(), "Appointment Booked Successfully!!"));
        }

    }
}
