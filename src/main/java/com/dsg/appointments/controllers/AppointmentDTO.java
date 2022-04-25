package com.dsg.appointments.controllers;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
class AppointmentDTO {
    LocalDateTime appointmentDateTime;
    String customerName;
    String experienceName;
    String experienceDescription;
    String teammateName;
    String teammateBio;
    Double cost;
    Boolean canceled;
}
