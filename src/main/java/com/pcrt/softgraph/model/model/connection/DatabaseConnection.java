package com.pcrt.softgraph.model.model.connection;

import com.pcrt.softgraph.model.model.DatabaseOperation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Representation of a database connection")
public class DatabaseConnection extends ConnectionModel {
    private String entity;
    private DatabaseOperation operation;
}
