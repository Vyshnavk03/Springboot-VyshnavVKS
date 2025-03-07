package com.vyshvks.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CategoryAlreadyExistsException extends RuntimeException{


    public CategoryAlreadyExistsException(String message){
        super(message);//super is provided so it goes to parent here for example runtime exception
    }
}
