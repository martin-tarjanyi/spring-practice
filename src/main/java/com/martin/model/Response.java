package com.martin.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Response
{
    private final int responseCode;
    private final String response;
    private final String name;

    public Response(int responseCode, String response, String name)
    {
        this.responseCode = responseCode;
        this.response = response;
        this.name = name;
    }

    public int getResponseCode()
    {
        return responseCode;
    }

    public String getResponse()
    {
        return response;
    }

    public String getName()
    {
        return name;
    }
}
