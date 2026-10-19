package SS6.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDoctorNotFound( DoctorNotFoundException ex){
       ErrorResponse error = new ErrorResponse(java.time.LocalDateTime.now(), ex.getMessage(),HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PatientNotFoundExcetion.class)
    public ResponseEntity<ErrorResponse> handlePatientNotFound(PatientNotFoundExcetion ex){
        ErrorResponse error = new ErrorResponse(
                java.time.LocalDateTime.now(), ex.getMessage(),HttpStatus.NOT_FOUND.value());
return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
