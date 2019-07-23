package com.example.demo.api.comm.validation;

public class ValidationException extends RuntimeException {
  public ValidationException() {
    super("validator error");
  }

  public ValidationException(String message) {
    super(message);
  }
}
