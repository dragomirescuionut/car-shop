package com.arasaka.carshop.exceptions;

import com.arasaka.carshop.models.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(EngineNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleEngineNotFoundException(EngineNotFoundException exception) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.getMessage().put("Engine Not Found!", exception.getMessage().toString());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handelMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        ErrorDTO errorDTO = new ErrorDTO();

        exception.getBindingResult().getFieldErrors()
                .forEach(error -> errorDTO.getMessage().put(error.getField(), error.getDefaultMessage()));

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}