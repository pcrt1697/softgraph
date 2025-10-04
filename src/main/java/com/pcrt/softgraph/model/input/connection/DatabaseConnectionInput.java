package com.pcrt.softgraph.model.input.connection;

import com.pcrt.softgraph.model.model.DatabaseOperation;
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
@Schema(description = "Object used to create a new database connection")
public class DatabaseConnectionInput extends ConnectionInput {
    @NotNull
    private Long idComponent;
    @NotNull
    private Long idDatabase;
    private String entity;
    private DatabaseOperation operation;
}
