package com.dsg.appointments.domain.ports.outbound;

import com.dsg.appointments.domain.models.Appointment;

import java.util.List;

// You may NOT edit this file

public interface AppointmentRetriever {
    List<Appointment> getAppointments();
}
