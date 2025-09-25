package com.pcrt.softgraph.model.node.microservice;

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
public class MicroserviceCallRelationship {


    @RelationshipId
    private Long id;
    @TargetNode
    private MicroserviceNode microservice;
    private String endpoint;
    @CompositeProperty
    private Map<String, Object> properties;

}
