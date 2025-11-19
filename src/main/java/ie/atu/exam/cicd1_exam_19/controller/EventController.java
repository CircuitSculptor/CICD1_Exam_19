package ie.atu.exam.cicd1_exam_19.controller;

import ie.atu.exam.cicd1_exam_19.model.Attendee;
import ie.atu.exam.cicd1_exam_19.service.EventRegistrationService;
import jdk.jfr.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/event")
public class EventController {
    private final EventRegistrationService service;
    public EventController(EventRegistrationService service) {
        this.service = service;
    }

    @GetMapping("{ticketCode}")
    public ResponseEntity<ArrayList<Attendee>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("{ticketCode}")
    public ResponseEntity<List<Attendee>> get(@PathVariable String ticketCode) {
        Optional<Event> maybe = service.findByTicketCode(ticketCode);
        if (maybe.isPresent()) {
            return ResponseEntity.ok((List<Attendee>) maybe.get());
        } else {
            throw new AttendeeNotFoundException(ticketCode);
        }
    }

}
