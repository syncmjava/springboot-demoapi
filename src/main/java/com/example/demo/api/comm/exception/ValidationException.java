package com.example.demo.api.comm.exception;

import lombok.Getter;
import org.springframework.validation.FieldError;

import java.util.List;

@Getter
public class ValidationException extends RuntimeException {
  private List<FieldError> errors;

  public ValidationException() {
    super("validator error");
  }

  public ValidationException(List<FieldError> errors, String message) {
    super(message);
    this.errors = errors;
  }

  public ValidationException(String message) {
    super(message);
  }
}
