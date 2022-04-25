package com.dsg.appointments.repository;

import com.dsg.appointments.domain.models.Appointment;
import com.dsg.appointments.domain.models.Experience;
import com.dsg.appointments.domain.models.Teammate;
import com.dsg.appointments.domain.ports.outbound.AppointmentRetriever;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static com.dsg.appointments.Constants.*;

@Component
class AppointmentRetrieverImpl implements AppointmentRetriever {
    private static final LocalDate TODAY = LocalDate.now();
    private static final LocalDate YESTERDAY = TODAY.minusDays(1);
    private static final LocalDate TOMORROW = TODAY.plusDays(1);

    static final Experience BASEBALL_LESSON = Experience.builder()
        .id(BASEBALL_LESSON_ID)
        .title("Baseball Lesson")
        .description("Want to get better at hitting a baseball? Want not to get hit on the head with a baseball as much? This is for you!")
        .cost(29.99)
        .build();

    static final Experience BASKETBALL_LESSON = Experience.builder()
        .id(BASKETBALL_LESSON_ID)
        .title("Basketball Lesson")
        .description("Tired of getting laughed at on the court?  This is for you!")
        .cost(49.99)
        .build();

    public static final Teammate JOHN_DOE = Teammate.builder()
        .id(JOHN_DOE_TEAMMATE_ID)
        .firstName("John")
        .lastName("Doe")
        .bio("John's baseball career began in 1999 when he got hit on the head with a baseball.")
        .build();

    public static final Teammate MARY_SMITH = Teammate.builder()
        .id(MARY_SMITH_TEAMMATE_ID)
        .firstName("Mary")
        .lastName("Smith")
        .bio("Mary has played both baseball and basketball professionally. Do not mess with Mary.")
        .build();

    static List<Appointment> ALL_APPOINTMENTS;

    static {
        ALL_APPOINTMENTS = Arrays.asList(
            Appointment.builder()
                .id(UUID.randomUUID())
                .date(TODAY)
                .time(LocalTime.of(10, 0))
                .customerFirstName("Ed")
                .customerLastName("Sanders")
                .experience(BASEBALL_LESSON)
                .teammate(JOHN_DOE)
                .build(),
            Appointment.builder()
                .id(UUID.randomUUID())
                .date(TODAY)
                .time(LocalTime.of(11, 0))
                .customerFirstName("Trevor")
                .customerLastName("Schadt")
                .experience(BASEBALL_LESSON)
                .teammate(JOHN_DOE)
                .build(),
            Appointment.builder()
                .id(UUID.randomUUID())
                .date(TODAY)
                .time(LocalTime.of(11, 0))
                .customerFirstName("Matthew")
                .customerLastName("Bertoni")
                .experience(BASEBALL_LESSON)
                .teammate(MARY_SMITH)
                .canceled(true)
                .build(),
            Appointment.builder()
                .id(UUID.randomUUID())
                .date(TODAY)
                .time(LocalTime.of(13, 0))
                .customerFirstName("Jason")
                .customerLastName("Barron")
                .experience(BASEBALL_LESSON)
                .teammate(MARY_SMITH)
                .build(),
            Appointment.builder()
                .id(UUID.randomUUID())
                .date(TODAY)
                .time(LocalTime.of(13, 30))
                .customerFirstName("Jason")
                .customerLastName("Guttman")
                .experience(BASEBALL_LESSON)
                .teammate(JOHN_DOE)
                .build(),
            Appointment.builder()
                .id(UUID.randomUUID())
                .date(YESTERDAY)
                .customerFirstName("Jason")
                .customerLastName("Richards")
                .time(LocalTime.of(13, 30))
                .experience(BASKETBALL_LESSON)
                .teammate(MARY_SMITH)
                .build(),
            Appointment.builder()
                .id(UUID.randomUUID())
                .date(YESTERDAY)
                .time(LocalTime.of(13, 30))
                .customerFirstName("D.J.")
                .customerLastName("Brady")
                .experience(BASKETBALL_LESSON)
                .teammate(JOHN_DOE)
                .canceled(true)
                .build(),
            Appointment.builder()
                .id(UUID.randomUUID())
                .date(TOMORROW)
                .time(LocalTime.of(13, 30))
                .customerFirstName("Trevor")
                .customerLastName("Schadt")
                .experience(BASEBALL_LESSON)
                .teammate(JOHN_DOE)
                .build(),
            Appointment.builder()
                .id(UUID.randomUUID())
                .date(TOMORROW)
                .time(LocalTime.of(11, 30))
                .customerFirstName("Trevor")
                .customerLastName("Schadt")
                .experience(BASEBALL_LESSON)
                .teammate(JOHN_DOE)
                .canceled(true)
                .build(),
            Appointment.builder()
                .id(UUID.randomUUID())
                .date(TOMORROW)
                .time(LocalTime.of(12, 30))
                .customerFirstName("Trevor")
                .customerLastName("Schadt")
                .experience(BASEBALL_LESSON)
                .teammate(JOHN_DOE)
                .canceled(true)
                .build(),
            Appointment.builder()
                .id(UUID.randomUUID())
                .date(TOMORROW)
                .time(LocalTime.of(14, 0))
                .customerFirstName("Will")
                .customerLastName("McAvoy")
                .experience(BASKETBALL_LESSON)
                .teammate(MARY_SMITH)
                .build(),
            Appointment.builder()
                .id(UUID.randomUUID())
                .date(YESTERDAY)
                .time(LocalTime.of(8, 0))
                .customerFirstName("Mackenzie")
                .customerLastName("McHale")
                .experience(BASEBALL_LESSON)
                .teammate(MARY_SMITH)
                .canceled(true)
                .build(),
            Appointment.builder()
                .id(UUID.randomUUID())
                .date(TODAY)
                .time(LocalTime.of(8, 0))
                .customerFirstName("Jim")
                .customerLastName("Harper")
                .experience(BASEBALL_LESSON)
                .teammate(MARY_SMITH)
                .build(),
            Appointment.builder()
                .id(UUID.randomUUID())
                .date(TODAY)
                .time(LocalTime.of(8, 0))
                .customerFirstName("Don")
                .customerLastName("Keefer")
                .experience(BASEBALL_LESSON)
                .teammate(JOHN_DOE)
                .build()
        );
        Collections.shuffle(ALL_APPOINTMENTS);
    }


    @Override
    public List<Appointment> getAppointments() {
        return ALL_APPOINTMENTS;
    }
}
