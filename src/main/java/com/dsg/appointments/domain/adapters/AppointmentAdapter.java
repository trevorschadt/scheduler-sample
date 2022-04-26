package com.dsg.appointments.domain.adapters;

import com.dsg.appointments.domain.models.Appointment;
import com.dsg.appointments.domain.ports.inbound.AppointmentRetriever;
import org.springframework.stereotype.Component;

import java.util.List;

// You may edit this file

@Component
public class AppointmentAdapter implements AppointmentRetriever {

    private final com.dsg.appointments.domain.ports.outbound.AppointmentRetriever appointmentRetriever;

    public AppointmentAdapter(com.dsg.appointments.domain.ports.outbound.AppointmentRetriever appointmentRetriever) {
        this.appointmentRetriever = appointmentRetriever;
    }

    @Override
    public List<Appointment> getAllAppointments(AppointmentQuery query) {
        AppointmentQueryTyped q = validate(query);

        List<Appointment> list = appointmentRetriever.getAppointments();

        if (q.getDate() != null) {
            list = list.filter(a -> { a.getDate().equals(q.getDate()); }); // localdate comparison is same day (can use ==)
        }

        if (q.getExperience() != null) {
            list = list.filter(a -> a.getExperience().getId().equals(q.getExperience()));
        }

        if (q.getTeammate() != null) {
            list = list.filter(a -> a.getTeammate().getId().equals(q.getTeammate()));
        }

        return list;
    }

    private AppointmentQueryTyped validate(AppointmentQuery query) {
        Date resultingDate = testDate(query.getDate());

        UUID experience;
        try {
            experience = UUID.fromString(query.getExperience());
        } catch (IllegalArgumentException iae) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Experience was not a uuid", iae);
        }

        return new AppointmentQueryTyped();
    }

    private boolean testDate(String maybeDate) {
        if (null == Pattern.compile("\d\d\d\d-\d\d-\d\d").test(query.getDate())) { // check this api
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Given date was not a date (" + queyr.getDate() + ").");
        }

        return new Date(); // use some libary to actually parse a date into year, month, day
    }

    @lombok.Value
    private static class AppointmentQueryTyped {
        LocalDate date;
        java.util.UUID experience;
        java.util.UUID teammate;
    }
}
