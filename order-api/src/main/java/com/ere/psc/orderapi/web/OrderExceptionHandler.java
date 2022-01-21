package com.ere.psc.orderapi.web;

import com.ere.psc.orderapi.config.ClassLogger;
import com.ere.psc.orderapi.model.response.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrderExceptionHandler extends ClassLogger {

    private static final String title = "Service problem";

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ErrorMessage handleAllException(Exception exception) {
        logger.error("service exception", exception);
        return new ErrorMessage(title, exception.getMessage(), null); // TODO: add span uuid
    }
}
