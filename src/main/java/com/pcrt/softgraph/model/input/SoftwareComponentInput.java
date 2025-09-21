package com.pcrt.softgraph.model.input;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class SoftwareComponentInput {
    @NotEmpty
    private String name;
    private String documentationUrl;
    private String description;
}
