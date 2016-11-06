package com.martin.controller;

import javax.validation.Valid;

import com.martin.model.Response;
import com.martin.model.parameter.Parameters;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSONController
{
    @RequestMapping("/json")
    public Response json(@Valid Parameters parameters)
    {
        return new Response(200, "Hello World!", parameters.getName());
    }

    @RequestMapping("/json/{number}")
    public Response path(@PathVariable int number)
    {
        return new Response(200, String.valueOf(number), null);
    }
}
