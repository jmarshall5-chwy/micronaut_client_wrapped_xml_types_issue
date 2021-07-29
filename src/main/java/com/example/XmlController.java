package com.example;

import com.example.data.Request;
import com.example.data.Response;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;

@Controller(value = "v1.0/xml", consumes = MediaType.APPLICATION_XML, produces = MediaType.APPLICATION_XML)
//@Validated
@Slf4j
public class XmlController {

    @Post(uri = "request")
    public Response request(final /*@Valid*/ @NonNull @Body(value = "RateRequest") Request request) {
        log.info("Request received: {}", request);
        return Response.builder().errorCode(0).build();
    }
}
