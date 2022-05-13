package com.dsg.appointments.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import com.dsg.appointments.Constants;
import com.dsg.appointments.domain.models.Appointment;
import com.dsg.appointments.domain.models.Experience;
import com.dsg.appointments.domain.models.Teammate;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

public class AppointmentMapperTest {
    private static AppointmentMapper testSubject = Mappers.getMapper(AppointmentMapper.class);
    @Test
    void toDto_shouldMapFromAppointmentToAppointmentDto() {
        LocalDate theDate = LocalDate.now();
        LocalTime theTime = LocalTime.of(10, 0);
        Appointment source = Appointment.builder()
                .canceled(false)
                .customerFirstName("sample-first-name")
                .customerLastName("sample-last-name")
                .date(theDate)
                .experience(Experience.builder()
                        .id(Constants.BASEBALL_LESSON_ID)
                        .title("Baseball Lesson")
                        .description(
                                "Want to get better at hitting a baseball? Want not to get hit on the head with a baseball as much? This is for you!")
                        .cost(29.99)
                        .build())
                .id(UUID.randomUUID())
                .teammate(Teammate.builder()
                        .id(Constants.JOHN_DOE_TEAMMATE_ID)
                        .firstName("John")
                        .lastName("Doe")
                        .bio("John's baseball career began in 1999 when he got hit on the head with a baseball.")
                        .build())
                .time(theTime)
                .build();
        AppointmentDTO expectedTarget = AppointmentDTO.builder()
            .appointmentDateTime(LocalDateTime.of(theDate, theTime))
            .canceled(false)
            .cost(29.99)
            .customerName("sample-first-name sample-last-name")
            .experienceDescription("Want to get better at hitting a baseball? Want not to get hit on the head with a baseball as much? This is for you!")
            .experienceName("Baseball Lesson")
            .teammateBio("John's baseball career began in 1999 when he got hit on the head with a baseball.")
            .teammateName("John Doe")
            .build();
        assertThat(testSubject.toDto(source)).isEqualTo(expectedTarget);
    }
}
