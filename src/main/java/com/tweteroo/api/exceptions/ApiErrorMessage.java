package com.tweteroo.api.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class ApiErrorMessage {

    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ApiErrorMessage(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiErrorMessage(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        this.errors = Arrays.asList(error);
    }

    //Getters and Setters
}