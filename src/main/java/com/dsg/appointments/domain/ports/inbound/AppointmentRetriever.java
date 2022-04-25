package com.dsg.appointments.domain.ports.inbound;

import com.dsg.appointments.domain.models.Appointment;

import java.util.List;

public interface AppointmentRetriever {
    List<Appointment> getAllAppointments();
}
