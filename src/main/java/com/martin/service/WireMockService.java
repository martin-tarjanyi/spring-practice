package com.martin.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.any;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

@Component
public class WireMockService
{
    private static final String STUBS_FOLDER = "stubs";
    private static final String APPLICATION_URL = "http://localhost:9999";

    public WireMockService() throws IOException
    {
        WireMockServer server = new WireMockServer();

        server.stubFor(any(urlEqualTo("/json")).willReturn(aResponse().proxiedFrom(APPLICATION_URL)));
        server.stubFor(any(urlEqualTo("/hello")).willReturn(aResponse().withBody(getFileContent("hello.json"))));
        server.stubFor(any(urlEqualTo("/sos")).willReturn(aResponse().withBody(getFileContent("sos.json"))));
        server.stubFor(any(urlEqualTo("/os")).willReturn(aResponse().withBody(getFileContent("os.json"))));

        server.start();
    }

    private String getFileContent(String fileName) throws IOException
    {
        Resource resource = new ClassPathResource(STUBS_FOLDER + File.separator + fileName);

        return IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);
    }
}
