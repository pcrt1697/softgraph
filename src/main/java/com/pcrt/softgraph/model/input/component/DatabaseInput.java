package com.pcrt.softgraph.model.input.component;

import com.pcrt.softgraph.model.model.DatabaseTechnology;
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
@Schema(description = "Object used to create a new database component")
public class DatabaseInput extends ComponentInput {
    @NotNull
    private DatabaseTechnology technology;
    private String serviceUrl;
}
