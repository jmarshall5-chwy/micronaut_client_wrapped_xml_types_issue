package com.example.data;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
//@Introspected
@Builder
public class NestedItem {
    private @NotEmpty String containerId;
    private @NotEmpty String someData;
}
