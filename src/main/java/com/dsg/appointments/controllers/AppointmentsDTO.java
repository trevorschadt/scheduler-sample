package com.dsg.appointments.controllers;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.util.List;

@Value
@Builder
class AppointmentsDTO {
    @Singular
    List<AppointmentDTO> appointments;
}
