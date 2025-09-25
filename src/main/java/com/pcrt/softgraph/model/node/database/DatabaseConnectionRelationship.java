package com.pcrt.softgraph.model.node.database;

import com.pcrt.softgraph.model.entity.database.DatabaseOperation;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.CompositeProperty;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.Map;

@Getter
@Setter
@ToString
@RelationshipProperties
public class DatabaseConnectionRelationship {

    @RelationshipId
    private Long id;
    @TargetNode
    private DatabaseNode database;
    private DatabaseOperation operation;
    private String entityName;
    @CompositeProperty
    private Map<String, Object> properties;

}
