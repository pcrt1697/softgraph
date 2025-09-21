package com.pcrt.softgraph.model.entity.database;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatabaseConnectionEntity {
    private Long id;
    private DatabaseOperation operation;
    private String entityName;
    private DatabaseEntity database;
}
