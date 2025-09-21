package com.pcrt.softgraph.model.input;

import com.pcrt.softgraph.model.entity.database.DatabaseTechnology;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Schema
public class DatabaseInput extends SoftwareComponentInput {
    @NotNull
    private DatabaseTechnology technology;
    private String hostname;
    private Map<String, Object> properties;
}
