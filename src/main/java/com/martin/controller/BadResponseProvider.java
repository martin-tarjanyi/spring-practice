package com.martin.controller;

import com.martin.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BadResponseProvider
{
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> error(Exception ex)
    {
        return new ResponseEntity<>(new Response(500, "Oops, something unexpected happened.", null),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
