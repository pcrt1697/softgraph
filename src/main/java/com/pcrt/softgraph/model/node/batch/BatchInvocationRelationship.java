package com.pcrt.softgraph.model.node.batch;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.CompositeProperty;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.Map;

@Getter
@Setter
@RelationshipProperties
public class BatchInvocationRelationship {

    @RelationshipId
    private Long id;
    private Integer order;
    @CompositeProperty
    private Map<String, Object> parameters;
    @TargetNode
    private BatchNode batch;

}
