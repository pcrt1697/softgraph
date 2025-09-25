package com.pcrt.softgraph.model.node.batch;

import com.pcrt.softgraph.model.entity.ProgrammingLanguage;
import com.pcrt.softgraph.model.node.ComponentNode;
import com.pcrt.softgraph.model.node.database.DatabaseConnectionRelationship;
import com.pcrt.softgraph.model.node.microservice.MicroserviceCallRelationship;
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
    private List<BatchInvocationRelationship> invokedBatches;
    @Relationship(type = "CONNECTED_TO", direction = Relationship.Direction.OUTGOING)
    private List<DatabaseConnectionRelationship> databaseConnections;
    @Relationship(type = "CALLS", direction = Relationship.Direction.OUTGOING)
    private List<MicroserviceCallRelationship> microserviceCalls;

    public void addBatchInvocations(List<BatchInvocationRelationship> invocations) {
        if (this.invokedBatches == null) {
            this.invokedBatches = new ArrayList<>();
        }
        this.invokedBatches.addAll(invocations);
    }

}
