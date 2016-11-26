package com.martin.service;

import java.io.IOException;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.springframework.stereotype.Component;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.any;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

@Component
public class WireMockService
{
    private static final String STUBS_FOLDER = "wiremock";
    private static final String APPLICATION_URL = "http://localhost:9999";

    public WireMockService() throws IOException
    {
        WireMockServer server = new WireMockServer(WireMockConfiguration.options().usingFilesUnderClasspath(STUBS_FOLDER));

        server.stubFor(any(urlEqualTo("/json")).willReturn(aResponse().proxiedFrom(APPLICATION_URL)));

        server.stubFor(any(urlEqualTo("/hello")).willReturn(aResponse().withBodyFile(("hello.json"))));
        server.stubFor(any(urlEqualTo("/sos")).willReturn(aResponse().withBodyFile(("sos.json"))));
        server.stubFor(any(urlEqualTo("/os")).willReturn(aResponse().withBodyFile(("os.json"))));

        server.start();
    }
}
