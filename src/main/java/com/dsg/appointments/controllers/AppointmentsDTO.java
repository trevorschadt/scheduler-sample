package com.dsg.appointments.controllers;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
class AppointmentsDTO {
    List<AppointmentDTO> appointments;
}
