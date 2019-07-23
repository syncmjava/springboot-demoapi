package com.example.demo.api.application.handler;

import com.example.demo.api.comm.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiExceptionHandler {

  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<?> handleBusinessException(ValidationException vex) {

    List<?> fieldErrorDtos = vex.getErrors().stream().collect(Collectors.toList());

    //        LOGGER.error(e.getMessage(), e);
    //
    //        AppResponse response = new AppResponse();
    //        response.setFail(e.getMessage());
    return new ResponseEntity(fieldErrorDtos, HttpStatus.BAD_REQUEST);
  }
}
