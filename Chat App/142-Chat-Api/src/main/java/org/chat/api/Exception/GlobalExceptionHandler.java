package org.chat.api.Exception;

import org.chat.api.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler   {


    /*
    this class for catch exceptions and convert it to a Errorresponse
     */

    @ExceptionHandler(MessageNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMessageNotFoundException(MessageNotFoundException e) {
        ErrorResponse errorResponse =ErrorResponse.builder().message(e.getMessage()).build();
    return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
}
