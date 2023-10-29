package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException(List<String> errorMessages) {
        super(errorMessages.toString());
    }

    public NotFoundException(String errorMessage){
        super(errorMessage);
    }
}
