package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    public BadRequestException(List <String> errorMessages) {
        super(errorMessages.toString());
    }

    public BadRequestException(String errorMessage){
        super(errorMessage);
    }

}