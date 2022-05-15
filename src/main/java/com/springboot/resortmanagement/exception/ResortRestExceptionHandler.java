package com.springboot.resortmanagement.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResortRestExceptionHandler {


    // Add an exception handler for ResortNotFoundException
    @ExceptionHandler
    public ResponseEntity<ResortErrorResponse> handleException(ResortNotFoundException exc){

        // create CustomerErrorResponse

        ResortErrorResponse error = new ResortErrorResponse(HttpStatus.NOT_FOUND.value(),exc.getMessage(),System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    // Add another exception hadler... to catch any exception(catch all)
    @ExceptionHandler
    public ResponseEntity<ResortErrorResponse> handleException(Exception exc){

        // create CustomerErrorResponse

        ResortErrorResponse error = new ResortErrorResponse(HttpStatus.BAD_REQUEST.value(),exc.getMessage(),System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
