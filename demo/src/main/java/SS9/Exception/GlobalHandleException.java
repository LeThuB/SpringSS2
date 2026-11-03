package SS9.Exception;

import SS9.Exception.CustomException.DuplicateResourceException;
import SS9.Exception.CustomException.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.validation.FieldError;
@RestControllerAdvice
public class GlobalHandleException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse<Map<String,String>>> validException(MethodArgumentNotValidException ex) {
Map<String,String> errors = new HashMap<>();
ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
    errors.put(fieldError.getField(),fieldError.getDefaultMessage());
});
ErrorResponse<Map<String,String>> errorResponse = ErrorResponse.<Map<String,String>>builder()
        .status(HttpStatus.BAD_REQUEST.value())
        .message("Loi validate")
        .timestamp(LocalDateTime.now())
        .data(errors).build();
return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse<String>> NotFound(ResourceNotFoundException ex){
        ErrorResponse<String> errorResponse = ErrorResponse.<String>builder()
                .status(404)
                .message("Resource NOt Found ")
                .timestamp(LocalDateTime.now())
                .data("Khong tim thay phong ban co ID").build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

//    @ExceptionHandler(DuplicateResourceException.class)
//    public
}