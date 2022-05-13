package com.dsg.appointments.controllers;

import java.util.stream.Collectors;

import com.dsg.appointments.domain.adapters.AppointmentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// You may edit this file

@RestController
@RequestMapping("appointments")
class AppointmentController {
    private final AppointmentService appointmentService;
    private final AppointmentMapper appointmentMapper;

    AppointmentController(AppointmentService appointmentRetriever, AppointmentMapper appointmentMapper) {
        this.appointmentService = appointmentRetriever;
        this.appointmentMapper = appointmentMapper;
    }

    @GetMapping
    ResponseEntity<AppointmentsDTO> getAllAppointments() {
        return ResponseEntity.ok(AppointmentsDTO.builder()
                .appointments(appointmentService.getAllAppointments().stream()
                        .map(appointmentMapper::toDto).collect(Collectors.toList()))
                .build());
    }

    /*
     * YOUR TASK: Write an endpoint that can take zero or more of the following
     * query
     * parameters:
     * - date: If specified (in YYYY-MM-DD format), only appointments on this date
     * will be returned.
     * - If the date is in an invalid format, return a 400 result.
     * - experience_id: If specified (UUID), only appointments of that experience
     * will be returned
     * - teammate_id: If specified (UUID), only appointments for that teammate will
     * be returned
     * If there are one or more results, return a 200 result with an AppointmentsDTO
     * object containing a list of the valid appointments.
     * If there are no results, return a 404 result.
     * If the AppointmentService throws any error, log it and then return a 500
     * result.
     */

}
