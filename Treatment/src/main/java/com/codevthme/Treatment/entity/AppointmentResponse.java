package com.codevthme.Treatment.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponse {
    private Appointment appointment;
    private String message;
}
