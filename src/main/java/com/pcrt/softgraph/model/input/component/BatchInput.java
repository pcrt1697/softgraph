package com.pcrt.softgraph.model.input.component;

import com.pcrt.softgraph.model.model.ProgrammingLanguage;
import com.pcrt.softgraph.validation.ValidCronExpression;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Object used to create a new batch component")
public class BatchInput extends ComponentInput {
    @NotNull
    private ProgrammingLanguage programmingLanguage;
    private String repositoryUrl;
    @ValidCronExpression
    private String cronExpression;
}
