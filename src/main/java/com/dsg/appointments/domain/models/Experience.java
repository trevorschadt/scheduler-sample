package com.dsg.appointments.domain.models;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class Experience {
    UUID id;
    String title;
    String description;
    Double cost;
}
