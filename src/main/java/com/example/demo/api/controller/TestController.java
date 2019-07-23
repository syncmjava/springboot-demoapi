package com.example.demo.api.controller;

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

    @GetMapping(value = "/user")
    public TestResponse getUser(@ModelAttribute @Validated TestRequest request, BindingResult result){
        if(result.hasFieldErrors()){

            // TODO


        }
        TestResponse res=new TestResponse();
        return res;
    }
}
