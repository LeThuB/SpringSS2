package SS8.SS83.GlobalExceptionHandle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@RestControllerAdvice
public class GlobalExceptionHandle {
@ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<String> handleMaxSizeEx(MaxUploadSizeExceededException ex){
    return new ResponseEntity<>("File qua lon", HttpStatus.PAYLOAD_TOO_LARGE);
}
}

