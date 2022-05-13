package com.dsg.appointments.controllers;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.dsg.appointments.Constants;
import com.dsg.appointments.domain.adapters.AppointmentService;
import com.dsg.appointments.domain.models.Appointment;
import com.dsg.appointments.domain.models.Experience;
import com.dsg.appointments.domain.models.Teammate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class AppointmentControllerTest {

    private MockMvc mockMvc;
    @Mock
    private AppointmentService appointmentRetriever;
    private AppointmentMapper appointmentMapper = Mappers.getMapper(AppointmentMapper.class);
    private static ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    @BeforeEach
    void setUp() {
        AppointmentController testSubject = new AppointmentController(appointmentRetriever, appointmentMapper);
        mockMvc = MockMvcBuilders.standaloneSetup(testSubject).build();
    }

    // Use the com.dsg.appointments.Constants file to obtain valid IDs to use for
    // testing

    @Test
    void getAllAppointments_shouldReturnAMappedListOfReturnedAppointments() throws Exception {
        Appointment appointment1 = Appointment.builder()
                .canceled(false)
                .customerFirstName("sample-first-name")
                .customerLastName("sample-last-name")
                .date(LocalDate.now())
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
                .time(LocalTime.of(10, 0))
                .build();
        Appointment appointment2 = Appointment.builder()
                .canceled(false)
                .customerFirstName("sample-first-name-2")
                .customerLastName("sample-last-name-2")
                .date(LocalDate.now())
                .experience(Experience.builder()
                        .id(Constants.BASKETBALL_LESSON_ID)
                        .title("Basketball Lesson")
                        .description("Tired of getting laughed at on the court?  This is for you!")
                        .cost(49.99)
                        .build())
                .id(UUID.randomUUID())
                .teammate(Teammate.builder()
                        .id(Constants.MARY_SMITH_TEAMMATE_ID)
                        .firstName("Mary")
                        .lastName("Smith")
                        .bio("Mary has played both baseball and basketball professionally. Do not mess with Mary.")
                        .build())
                .time(LocalTime.of(10, 0))
                .build();

        List<Appointment> serviceResult = asList(appointment1, appointment2);
        doReturn(serviceResult).when(appointmentRetriever).getAllAppointments();
        AppointmentsDTO expectedResult = AppointmentsDTO.builder()
                .appointment(appointmentMapper.toDto(appointment1))
                .appointment(appointmentMapper.toDto(appointment2))
                .build();

        mockMvc.perform(get("/appointments"))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(expectedResult)));
    }

}