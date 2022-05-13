package com.dsg.appointments.controllers;

import com.dsg.appointments.domain.models.Appointment;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(source = "source", target = "customerName", qualifiedByName = "getCustomerName")
    @Mapping(source = "experience.cost", target = "cost")
    @Mapping(source = "experience.description", target = "experienceDescription")
    @Mapping(source = "experience.title", target = "experienceName")
    @Mapping(source = "teammate.bio", target = "teammateBio")
    @Mapping(source = "teammate.name", target = "teammateName")
    AppointmentDTO toDto(Appointment source);

    @Named("getCustomerName")
    default String getCustomerName(Appointment source) { return "%s %s".formatted(source.getCustomerFirstName(), source.getCustomerLastName()); }
}
