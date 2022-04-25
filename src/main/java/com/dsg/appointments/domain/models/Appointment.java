package com.dsg.appointments.domain.models;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Value
@Builder
public class Appointment {
    UUID id;
    LocalDate date;
    LocalTime time;
    String customerFirstName;
    String customerLastName;
    Experience experience;
    Teammate teammate;
    Boolean canceled;
}
