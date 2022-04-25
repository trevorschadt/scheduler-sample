package com.dsg.appointments.domain.models;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class Teammate {
    UUID id;
    String firstName;
    String lastName;
    String bio;
}
