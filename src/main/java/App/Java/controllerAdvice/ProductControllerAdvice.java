package App.Java.controllerAdvice;

import App.Java.exceptions.InvalidQuantityException;
import App.Java.exceptions.ProductNotFoundException;
import App.Java.exceptions.ProductNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ProductControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNullException.class)
    public ResponseEntity<Object> nullErrorHandler(){
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", "Nenhum dos campos pode ser nulo");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> notFoundErrorHandler(){
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", "Produto não encontrado");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(InvalidQuantityException.class)
    public ResponseEntity<Object> invalidQuantityErrorHandler(){
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", "Quantidade não pode ser menor que 1");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
