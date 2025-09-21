package com.pcrt.softgraph.model.node.batch;

import com.pcrt.softgraph.model.entity.ProgrammingLanguage;
import com.pcrt.softgraph.model.node.ComponentNode;
import com.pcrt.softgraph.model.node.database.DatabaseConnection;
import com.pcrt.softgraph.model.node.microservice.MicroserviceCall;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.CompositeProperty;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Node("Batch")
public class BatchNode extends ComponentNode {

    private ProgrammingLanguage programmingLanguage;
    private String repositoryUrl;
    private String chronExpression;
    @CompositeProperty
    private Map<String, Object> properties;

    @Relationship(type = "INVOKES", direction = Relationship.Direction.OUTGOING)
    private List<BatchInvocationRelationship> batches;
    @Relationship(type = "CONNECTED_TO", direction = Relationship.Direction.OUTGOING)
    private List<DatabaseConnection> databases;
    @Relationship(type = "CALLS", direction = Relationship.Direction.OUTGOING)
    private List<MicroserviceCall> microservices;

    public void addBatchInvocations(List<BatchInvocationRelationship> invocations) {
        if (this.batches == null) {
            this.batches = new ArrayList<>();
        }
        this.batches.addAll(invocations);
    }

}
