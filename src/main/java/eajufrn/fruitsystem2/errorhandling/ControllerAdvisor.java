package eajufrn.fruitsystem2.errorhandling;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor  {
    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleEntityNotFoundException(
            EntityNotFoundException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Entidade não encontrada");


        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    //--- Uma nova exceção será lançada quando o usuário desrespeitar alguma validação aplicada no objeto de requisição aguardado ---
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleEntityNotFoundException(
            MethodArgumentNotValidException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        System.out.println(ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage());


        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }


}
