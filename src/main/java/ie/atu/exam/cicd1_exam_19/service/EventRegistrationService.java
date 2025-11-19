package ie.atu.exam.cicd1_exam_19.service;

import ie.atu.exam.cicd1_exam_19.model.Attendee;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventRegistrationService {

    private final List<Attendee> store = new ArrayList<>();
    private @Valid Attendee aUpdated;

    public ArrayList<Object> findAll() {
        return new ArrayList<>(store);
    }

    public Optional<Attendee> findByTicketCode(String ticketCode, @Valid Attendee aUpdated) {
        for (Attendee event : store) {
            if (event.getAttendeeTicketCode().equals(ticketCode)) {
                return Optional.of(event);
            }
        }
        return Optional.empty();
    }

    public Optional<Attendee> create(Attendee a) {
        if (findByTicketCode(a.getTicketCode(), aUpdated).isPresent()) {
            throw new IllegalArgumentException("Ticket code already exists");
        }
        store.add(a);
        return Optional.of(a);
    }


    public boolean deleteByTicketCode(@Valid String ticketCode) {
        for (Attendee event : store) {
            if (event.getTicketCode().equals(ticketCode)) {
                store.remove(event);
            }
        }
        return false;
    }
}
