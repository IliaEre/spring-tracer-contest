package com.ere.psc.equipmentapi.web.handler;

import com.ere.psc.equipmentapi.config.AbstractLogger;
import com.ere.psc.equipmentapi.domain.exception.EquipmentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebExceptionHandler implements AbstractLogger {

    private static final String TITLE = "Problem with service...";

    @ExceptionHandler(EquipmentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNotFound(EquipmentNotFoundException exception) {
        logger().error("not found: " + exception.getMessage());
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handle(Exception exception) {
        logger().error(TITLE, exception);
        return ResponseEntity.badRequest().body(TITLE);
    }

}
