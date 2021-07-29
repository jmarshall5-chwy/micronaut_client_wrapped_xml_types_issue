package com.example.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@AllArgsConstructor
// JsonXXX also applies for XML parser/encoder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "RATE_RESPONSE")
@Jacksonized
@Introspected
@Builder
public class Response {
    @JsonProperty(value = "ERROR_CODE")
    private int errorCode;

    @JsonProperty(value = "ERROR_MESSAGE")
    private String errorMessage;
}
