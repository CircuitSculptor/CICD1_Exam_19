package ie.atu.exam.cicd1_exam_19.controller;

import ie.atu.exam.cicd1_exam_19.service.EventRegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EventController {
    private final EventRegistrationService service;
    public EventController(EventRegistrationService service) {
        this.service = service;
    }

}
