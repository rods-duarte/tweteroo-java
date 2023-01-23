package com.tweteroo.api.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
        public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

            @ExceptionHandler(InvalidUserAvatarException.class)
            public ResponseEntity<Object> handleInvalidUserAvatarException(
                InvalidUserAvatarException ex
            ) {
                List<String> details = new ArrayList<String>();
                details.add(ex.getMessage());

                ApiErrorMessage apiError = new ApiErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid avatar url format", details);

                return ResponseEntityBuilder.build(apiError);
            }

            // @Override
            // protected ResponseEntity<Object> handleMethodArgumentNotValidException(
            //     MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request
            // ) {
            //     List<String> details = new ArrayList<String>();
            //     details.add(ex.getMessage());

            //     ApiErrorMessage apiError = new ApiErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid avatar url format", details);

            //     return ResponseEntityBuilder.build(apiError); 
            // }

            
        }