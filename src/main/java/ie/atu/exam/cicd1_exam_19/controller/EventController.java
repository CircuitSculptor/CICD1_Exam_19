package ie.atu.exam.cicd1_exam_19.controller;

import ie.atu.exam.cicd1_exam_19.service.EventRegistrationService;
import jdk.jfr.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {
    private final EventRegistrationService service;
    public EventController(EventRegistrationService service) {
        this.service = service;
    }

    @GetMapping("{ticketCode}")
    public ResponseEntity<List<Event>> getAll(@PathVariable String ticketCode) {
        return ResponseEntity.ok(service.findAll());
    }

    
}
