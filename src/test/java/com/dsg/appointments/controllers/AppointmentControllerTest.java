package com.dsg.appointments.controllers;

import com.dsg.appointments.domain.ports.inbound.AppointmentRetriever;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class AppointmentControllerTest {

    private MockMvc mockMvc;
    @Mock
    private AppointmentRetriever appointmentRetriever;

    @BeforeEach
    void setUp() {
        AppointmentController testSubject = new AppointmentController(appointmentRetriever);
        mockMvc = MockMvcBuilders.standaloneSetup(testSubject).build();
    }

}