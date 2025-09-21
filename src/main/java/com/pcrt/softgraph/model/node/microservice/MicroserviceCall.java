package com.pcrt.softgraph.model.node.microservice;

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
public class MicroserviceCall {


    @RelationshipId
    private Long id;
    @TargetNode
    private MicroserviceNode microservice;
    private String endpoint;

}
