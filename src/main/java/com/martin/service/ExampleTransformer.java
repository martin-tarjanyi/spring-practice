package com.martin.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.extension.ResponseTransformer;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.Response;

public class ExampleTransformer extends ResponseTransformer
{
    @Override
    public Response transform(Request request, Response response, FileSource files, Parameters parameters)
    {
        String absoluteUrl = request.getUrl();

        Pattern pattern = Pattern.compile(".example.(\\d+)");

        Matcher matcher = pattern.matcher(absoluteUrl);

        String id = "";

        if (matcher.matches())
        {
            id = matcher.group(1);
        }

        return new Response.Builder().body(FileService.getFileContent("example_" + id + ".json")).build();
    }

    @Override
    public String getName()
    {
        return "ExampleTransformer";
    }

    @Override
    public boolean applyGlobally()
    {
        return false;
    }
}
