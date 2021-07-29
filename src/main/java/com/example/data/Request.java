package com.example.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.ReflectiveAccess;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
//@Introspected
@Builder
@JsonRootName(value = "SimpleRequest")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {
    /**
     * The order number for this request
     */
    private @NotEmpty String id;

    // This appears to work but requires removing the introspected annotation,
    // which in turn breaks validation.
    @ReflectiveAccess
    // Uncomment useWrapping to make it work
    @JacksonXmlElementWrapper(/*useWrapping = false, */localName = "nestedItems")
    private @NotEmpty List<NestedItem> nestedItem;
}
