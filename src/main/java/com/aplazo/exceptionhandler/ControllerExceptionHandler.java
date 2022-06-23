package com.aplazo.exceptionhandler;

import com.aplazo.error.CustomErrorDto;
import com.aplazo.exceptions.InvalidFieldsException;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({InvalidFieldsException.class, MethodArgumentTypeMismatchException.class, InvalidFieldsException.class})
    public ResponseEntity<CustomErrorDto> invalidPageParameterHandler(Exception e) {
        var error = new CustomErrorDto();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setError(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
