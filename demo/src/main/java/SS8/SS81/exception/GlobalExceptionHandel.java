package SS8.SS81.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandel {
   @ExceptionHandler(StudentNotFoundException.class)
public ResponseEntity<ErrorResponse> handleStudentNotFound(StudentNotFoundException ex){
       ErrorResponse error = new ErrorResponse(404,ex.getMessage(), LocalDateTime.now());
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

   }

}
