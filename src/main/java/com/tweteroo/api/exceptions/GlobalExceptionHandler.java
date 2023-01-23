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

            @ExceptionHandler(ResourceNotFoundException.class)
            public ResponseEntity<Object> handleResourceNotFoundException(
                ResourceNotFoundException ex
            ) {
                List<String> details = new ArrayList<String>();
                details.add(ex.getMessage());

                ApiErrorMessage apiError = new ApiErrorMessage(HttpStatus.NOT_FOUND, "Resource not found", details);

                return ResponseEntityBuilder.build(apiError);
            }

            @ExceptionHandler(InvalidUserAvatarException.class)
            public ResponseEntity<Object> handleInvalidUserAvatarException(
                InvalidUserAvatarException ex
            ) {
                List<String> details = new ArrayList<String>();
                details.add(ex.getMessage());

                ApiErrorMessage apiError = new ApiErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid avatar url format", details);

                return ResponseEntityBuilder.build(apiError);
            }
        }