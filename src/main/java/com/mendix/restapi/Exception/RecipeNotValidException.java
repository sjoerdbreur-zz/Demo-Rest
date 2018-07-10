package com.mendix.restapi.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecipeNotValidException  extends RuntimeException{
    public RecipeNotValidException(String exception) {
        super(exception);
    }
}
