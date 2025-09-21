package com.pcrt.softgraph.model.node.microservice;

import com.pcrt.softgraph.model.node.ComponentNode;
import com.pcrt.softgraph.model.entity.ProgrammingLanguage;
import com.pcrt.softgraph.model.node.database.DatabaseConnection;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.CompositeProperty;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Node("Microservice")
public class MicroserviceNode extends ComponentNode {

    private ProgrammingLanguage programmingLanguage;
    private String repositoryUrl;
    private String serviceUrl;
    @CompositeProperty
    private Map<String, Object> properties;

    @Relationship(type = "CONNECTED_TO", direction = Relationship.Direction.OUTGOING)
    private List<DatabaseConnection> databases;
    @Relationship(type = "CALLS", direction = Relationship.Direction.OUTGOING)
    private List<MicroserviceCall> microservices;

}
