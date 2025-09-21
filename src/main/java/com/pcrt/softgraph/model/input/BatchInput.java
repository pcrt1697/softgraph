package com.pcrt.softgraph.model.input;

import com.pcrt.softgraph.model.entity.ProgrammingLanguage;
import com.pcrt.softgraph.validation.ValidCronExpression;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class BatchInput extends SoftwareComponentInput {

    @NotNull
    private ProgrammingLanguage programmingLanguage;
    private String repositoryUrl;
    @ValidCronExpression
    private String chronExpression;
    private Map<String, Object> properties;

}
