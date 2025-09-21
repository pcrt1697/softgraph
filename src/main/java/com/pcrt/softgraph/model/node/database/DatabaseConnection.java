package com.pcrt.softgraph.model.node.database;

import com.pcrt.softgraph.model.entity.database.DatabaseOperation;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@Getter
@Setter
@ToString
@RelationshipProperties
public class DatabaseConnection {

    @RelationshipId
    private Long id;
    @TargetNode
    private DatabaseNode database;
    private DatabaseOperation operation;
    private String entityName;

}
