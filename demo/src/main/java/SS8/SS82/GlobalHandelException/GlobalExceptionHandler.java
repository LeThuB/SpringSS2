package SS8.SS82.GlobalHandelException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException(ArithmeticException ex){
    return new ResponseEntity<>("Khong the chia cho 0 ", HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
    return new ResponseEntity<>("du lieu nhap khong phai so",HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex){
    return new ResponseEntity<>("Loi he thong : "+ ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
}
}
