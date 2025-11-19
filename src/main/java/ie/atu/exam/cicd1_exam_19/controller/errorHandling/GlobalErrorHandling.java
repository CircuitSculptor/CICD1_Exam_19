package ie.atu.exam.cicd1_exam_19.controller.errorHandling;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class GlobalErrorHandling {
    //@ExceptionHandler(MethodArgumentNotValidException.class)
    /*
    public ResponseEntity<List<ExceptionDetail>> showErrorDetails(MethodArgumentNotValidException mae) {
        List<ExceptionDetails> errorList = new ArrayList<>();
        for (fieldError fieldError : mae.getBindingResult().getFieldErrors()) {
            ExceptionDetails.exceptionDetails = new ExceptionDetails();

        }
    }

     */


}
