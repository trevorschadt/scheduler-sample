package com.dsg.appointments.controllers;

import com.dsg.appointments.Constants;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/utils")
class UtilsController {
    @Value
    @Builder
    static class IdName {
        String name;
        UUID id;
    }

    @Value
    @Builder
    static class Response {
        @JsonProperty("experiences")
        @Singular
        List<IdName> experiences;
        @JsonProperty("teammates")
        @Singular
        List<IdName> teammates;
    }

    @GetMapping()
    ResponseEntity<Response> getAllUtils() {
        return ResponseEntity.ok(Response.builder()
            .teammate(IdName.builder().name("John Doe").id(Constants.JOHN_DOE_TEAMMATE_ID).build())
            .teammate(IdName.builder().name("Mary Smith").id(Constants.MARY_SMITH_TEAMMATE_ID).build())
            .experience(IdName.builder().name("Baseball Lesson").id(Constants.BASEBALL_LESSON_ID).build())
            .experience(IdName.builder().name("Basketball Lesson").id(Constants.BASKETBALL_LESSON_ID).build())
            .build());
    }
}
