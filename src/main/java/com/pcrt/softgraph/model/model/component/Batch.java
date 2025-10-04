package com.pcrt.softgraph.model.model.component;

import com.pcrt.softgraph.model.model.ProgrammingLanguage;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Representation of a batch component")
public class Batch extends ComponentModel {
    private ProgrammingLanguage programmingLanguage;
    private String repositoryUrl;
    private String cronExpression;
}
