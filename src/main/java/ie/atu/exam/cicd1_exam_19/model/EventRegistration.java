package ie.atu.exam.cicd1_exam_19.model;

import ie.atu.exam.cicd1_exam_19.service.EventRegistrationService;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRegistration {

    @NotBlank
    private String attendeeName;

    @Email
    private String attendeeEmail;

    @Pattern(regexp = "tk-[0-9]{4}")
    private String ticketCode;

    @Positive
    private int quantity;

}
