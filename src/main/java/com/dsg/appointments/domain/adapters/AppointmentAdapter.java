package com.dsg.appointments.domain.adapters;

import com.dsg.appointments.domain.models.Appointment;
import com.dsg.appointments.domain.ports.inbound.AppointmentRetriever;
import org.springframework.stereotype.Component;

import java.util.List;

// You may edit this file

@Component
public class AppointmentAdapter implements AppointmentRetriever {

    private final com.dsg.appointments.domain.ports.outbound.AppointmentRetriever appointmentRetriever;

    public AppointmentAdapter(com.dsg.appointments.domain.ports.outbound.AppointmentRetriever appointmentRetriever) {
        this.appointmentRetriever = appointmentRetriever;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return null;
    }
}
