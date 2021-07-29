package com.example.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@Jacksonized
@Introspected
@Builder
@JsonRootName(value = "SimpleRequest")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {
    /**
     * The order number for this request
     */
    private @NotEmpty String id;

    // Uncomment useWrapping to make it work
    @JacksonXmlElementWrapper(/*useWrapping = false, */localName = "nestedItems")
    private @NotEmpty List<NestedItem> nestedItem;
}
