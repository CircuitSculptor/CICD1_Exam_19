package ie.atu.exam.cicd1_exam_19.service;

import ie.atu.exam.cicd1_exam_19.model.Attendee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventRegistrationService {

    private final List<Attendee> store = new ArrayList<>();

    public ArrayList<Object> findAll() {
        return new ArrayList<>(store);
    }

    public Optional<Attendee> findByTicketCode(String ticketCode) {
        for (Attendee event : store) {
            if (event.getAttendeeTicketCode().equals(ticketCode)) {
                return Optional.of(event);
            }
        }
        return Optional.empty();
    }

    public Optional<Attendee> create(Attendee a) {
        if (findByTicketCode(a.getTicketCode()).isPresent()) {
            throw new IllegalArgumentException("Ticket code already exists");
        }
        store.add(a);
        return Optional.of(a);
    }



}
