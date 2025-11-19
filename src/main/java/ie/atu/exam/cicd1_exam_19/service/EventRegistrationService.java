package ie.atu.exam.cicd1_exam_19.service;

import jdk.jfr.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventRegistrationService {

    private final List<Event> store = new ArrayList<>();

    public ArrayList<Object> findAll() {
        return new ArrayList<>(store);
    }

    public Optional<Event> findByTicketCode(String ticketCode) {
        for (Event event : store) {
            if (event.getEventTicketCode().equals(ticketCode)) {
                return Optional.of(event);
            }
        }
    }





}
