package com.pcrt.softgraph.model.input;

import com.pcrt.softgraph.model.entity.ProgrammingLanguage;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Schema
public class MicroserviceInput extends SoftwareComponentInput {
    @NotNull
    private ProgrammingLanguage programmingLanguage;
    private String repositoryUrl;
    private String serviceUrl;
    private Map<String, Object> properties;
}
