package com.example.demo.api.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TestRequest {

    @NotBlank
    private String resStrq;

    @NotBlank(message = "Test field222 is Not Blank")
    private String resStrq22;

    @com.example.demo.api.comm.validation.NotBlank(item = "Test field333")
    private String resStrq333;

}
