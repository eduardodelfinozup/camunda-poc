package application.camunda.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Configuration
public class ResponseEntityUtil<T> {
    public ResponseEntity<?> resposeStatus(T responseInit, HttpStatus httpStatus) {
        return new ResponseEntity<T>(responseInit, httpStatus);
    }
}
