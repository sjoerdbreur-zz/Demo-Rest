package com.mendix.restapi.controller.advice;

import com.mendix.restapi.Exception.RecipeNotValidException;
import com.mendix.restapi.dto.MessageDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class RecipeAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDTO processNullPointerException(NullPointerException exception) {

        MessageDTO message = new MessageDTO();
        message.setMessage("Errors found in request, try again later");
        message.setType("ERROR");
        return message;
    }
    @ExceptionHandler(RecipeNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ResponseEntity<MessageDTO> handleUserNotFoundException(RecipeNotValidException ex, WebRequest request) {
        MessageDTO message = new MessageDTO();
        message.setType( ex.getMessage());
        message.setMessage(request.getDescription(false));;
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        MessageDTO msg = new MessageDTO();
        msg.setMessage(ex.getBindingResult().toString());
        msg.setType("Validation Failed");

        return new ResponseEntity(msg, HttpStatus.BAD_REQUEST);
    }
}

