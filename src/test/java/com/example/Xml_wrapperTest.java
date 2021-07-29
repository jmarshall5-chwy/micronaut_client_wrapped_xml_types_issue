package com.example;

import com.example.data.NestedItem;
import com.example.data.Request;
import com.example.data.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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

    static final Request theRequest = Request.builder()
            .id("1")
            .nestedItem(List.of(
                    NestedItem.builder()
                            .containerId("22")
                            .someData("something")
                            .build(),
                    NestedItem.builder()
                            .containerId("23")
                            .someData("something else")
                            .build()))
            .build();


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
        MutableHttpRequest<Request> request = HttpRequest.POST("/v1.0/xml/request",
                theRequest)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML);
        Response response = client.toBlocking().retrieve(request, Response.class);
        assertEquals(0, response.getErrorCode());
    }

    @Test
    void doBasicXmlRequestWorkAround() throws JsonProcessingException {
        // Create our own XMLMapper, this will use reflection!
        XmlMapper xmlMapper = new XmlMapper();
        // Create a string version of the request
        final String xml = xmlMapper.writeValueAsString(theRequest);
        MutableHttpRequest<String> request = HttpRequest.POST("/v1.0/xml/request", xml)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML);
        Response response = client.toBlocking().retrieve(request, Response.class);
        assertEquals(0, response.getErrorCode());
    }
}
