package com.example;

import com.example.data.NestedItem;
import com.example.data.Request;
import com.example.data.Response;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class Xml_wrapperTest {

    @Inject
    EmbeddedApplication<?> application;

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void doBasicXmlRequest() {
        MutableHttpRequest<Request> request = HttpRequest.POST("/v1.0/xml/request", Request.builder()
                .id("1")
                .nestedItem(List.of(NestedItem.builder()
                        .containerId("22")
                        .someData("something")
                        .build()))
                .build())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML);
        Response response = client.toBlocking().retrieve(request, Response.class);
        assertEquals(0, response.getErrorCode());
    }

}
