package com.dsg.appointments.domain.adapters;

import com.dsg.appointments.domain.models.Appointment;
import com.dsg.appointments.repository.AppointmentDatabaseAdapter;

import org.springframework.stereotype.Component;

import java.util.List;

// You may only edit this file through adding new methods; you may not edit the code that is already here

@Component
public class AppointmentService {

    private final AppointmentDatabaseAdapter appointmentDatabaseAdapter;

    public AppointmentService(AppointmentDatabaseAdapter appointmentRetriever) {
        this.appointmentDatabaseAdapter = appointmentRetriever;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentDatabaseAdapter.getAppointments();
    }
}
