package ie.atu.exam.cicd1_exam_19.controller.errorHandling;

public class AttendeeNotFoundException extends RuntimeException {
    public AttendeeNotFoundException(String message) {
        super(message);
    }

    private String message;
    private String field;

    public AttendeeNotFoundException(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
