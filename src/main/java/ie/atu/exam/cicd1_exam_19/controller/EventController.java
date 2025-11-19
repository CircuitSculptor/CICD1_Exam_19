package ie.atu.exam.cicd1_exam_19.controller;

import ie.atu.exam.cicd1_exam_19.model.Attendee;
import ie.atu.exam.cicd1_exam_19.service.EventRegistrationService;
import jakarta.validation.Valid;
import jdk.jfr.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Attendee>> getTicketCode(@Valid @PathVariable String ticketCode) {
        Optional<Attendee> maybe = service.findByTicketCode(ticketCode);
        if (maybe.isPresent()) {
            return ResponseEntity.ok((List<Attendee>) maybe.get());
        } else {
            throw new AttendeeNotFoundException(ticketCode);
        }
    }

    @PutMapping("/{ticketCode}")
    public ResponseEntity<Attendee> updateByTicketCode(@PathVariable String ticketCode, @Valid @RequestBody Attendee aUpdated) {
        Optional<Attendee> maybeUpdated = service.findByTicketCode(ticketCode, aUpdated);
        if (maybeUpdated.isPresent()) {
            return ResponseEntity.ok(maybeUpdated.get());
        } else {
            throw new AttendeeNotFoundException(ticketCode);
        }
    }

}
