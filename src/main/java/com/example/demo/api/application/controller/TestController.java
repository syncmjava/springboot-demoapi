package com.example.demo.api.application.controller;

import com.example.demo.api.comm.exception.ValidationException;
import com.example.demo.api.request.TestRequest;
import com.example.demo.api.response.TestResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

  @GetMapping(value = "/validator")
  public TestResponse getValidator(
      @ModelAttribute @Validated TestRequest request, BindingResult result) {
    if (result.hasFieldErrors()) {

      throw new ValidationException(result.getFieldErrors(), "validator error");
      // TODO
    }
    TestResponse res = new TestResponse();
    return res;
  }
}
