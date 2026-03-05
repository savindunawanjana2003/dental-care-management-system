package lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Exseption;

import jakarta.persistence.EntityExistsException;
import lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Util.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)

    public ResponseEntity<APIResponse<String>> handleUsernameNotFoundException(UsernameNotFoundException e) {
        return new ResponseEntity<>(new APIResponse<>
                (HttpStatus.NOT_FOUND.value(),
                        "User Not Found", e.getMessage())
                , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse<String>> handleGeneralException(Exception e) {
        return new ResponseEntity<>(new APIResponse<>
                (HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "Internal Server Error", e.getMessage())
                , HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<APIResponse<String>> handleNullPointerException(NullPointerException e) {
        return new ResponseEntity<>(new APIResponse<>
                (HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "Null", e.getMessage())
                , HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse<Object>> handleMethodArgumentNotValidException
            (MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach((fieldError) -> {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return new ResponseEntity<>(new APIResponse<>
                (HttpStatus.BAD_REQUEST.value(),
                        "Bad Request", errors
                ), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlredyExistException.class)

    public ResponseEntity<APIResponse<String>> handleUserAlredyExistException(UserAlredyExistException e) {
        return new ResponseEntity<>(new APIResponse<>
                (HttpStatus.BAD_REQUEST.value(),
                        "User Alredy avelable", "")
                , HttpStatus.NOT_FOUND);
    }

}
