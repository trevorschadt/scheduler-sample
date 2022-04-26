package com.dsg.appointments.domain.ports.inbound;

import com.dsg.appointments.domain.models.Appointment;
import com.dsg.appointments.domain.models.AppointmentQ;

import java.util.List;

// You may edit this file

public interface AppointmentRetriever {
    List<Appointment> getAllAppointments(AppointmentQuery query);
}
