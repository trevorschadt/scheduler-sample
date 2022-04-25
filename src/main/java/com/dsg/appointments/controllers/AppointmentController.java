package com.dsg.appointments.controllers;

import com.dsg.appointments.domain.ports.inbound.AppointmentRetriever;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("appointments")
class AppointmentController {
    private final AppointmentRetriever appointmentRetriever;

    AppointmentController(AppointmentRetriever appointmentRetriever) {
        this.appointmentRetriever = appointmentRetriever;
    }

    /*
      TODO: Write an endpoint that can take zero or more of the following query parameters:
      - date: If specified (in YYYY-MM-DD format), only appointments on this date will be returned.
           - If the date is in an invalid format, return a 400 result.
           - allowed values: yesterday, today, tomorrow
      - experience_id: If specified (UUID), only appointments of that experience will be returned
           - allowed values: Constants.BASEBALL_LESSON_ID, Constants.BASKETBALL_LESSON_ID
      - teammate_id: If specified (UUID), only appointments for that teammate will be returned
           - allowed values: Constants.JOHN_DOE_TEAMMATE_ID, Constants.MARY_SMITH_TEAMMATE_ID
      If there are one or more results, return a 200 result with an AppointmentsDTO object containing
           a list of the valid appointments.
      If there are no results, return a 404 result.
      If the AppointmentRetriever throws any error, log it and then return a 500 result.
     */

}
