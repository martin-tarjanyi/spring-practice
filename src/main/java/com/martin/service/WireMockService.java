package com.martin.service;

import java.io.IOException;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.stereotype.Component;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.any;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static com.martin.service.FileService.getFileContent;

@Component
public class WireMockService
{
    private static final String APPLICATION_URL = "http://localhost:9999";

    public WireMockService() throws IOException
    {
        WireMockServer server = new WireMockServer(options().extensions(ExampleTransformer.class));

        server.stubFor(any(urlEqualTo("/json")).willReturn(aResponse().proxiedFrom(APPLICATION_URL)));
        server.stubFor(any(urlEqualTo("/hello")).willReturn(aResponse().withBody(getFileContent("hello.json"))));
        server.stubFor(any(urlEqualTo("/sos")).willReturn(aResponse().withBody(getFileContent("sos.json"))));
        server.stubFor(any(urlEqualTo("/os")).willReturn(aResponse().withBody(getFileContent("os.json"))));

        server.stubFor(any(urlMatching("/example/\\d+")).willReturn(aResponse().withBody("gaia")
                                                                               .withTransformers("ExampleTransformer")));

        server.start();
    }
}
