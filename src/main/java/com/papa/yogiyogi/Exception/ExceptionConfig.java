package com.papa.yogiyogi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionConfig {
    @ExceptionHandler(LoginException.class)
    public ResponseEntity<?> loginException (LoginException e ){
        ResponseEntity<?> responseEntity =
                new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        return responseEntity;
    }
}
