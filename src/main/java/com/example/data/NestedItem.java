package com.example.data;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@Jacksonized
@Introspected
@Builder
public class NestedItem {
    private @NotEmpty String containerId;
    private @NotEmpty String someData;
}
