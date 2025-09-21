package com.pcrt.softgraph.model.node.database;

import com.pcrt.softgraph.model.entity.database.DatabaseTechnology;
import com.pcrt.softgraph.model.node.ComponentNode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.CompositeProperty;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Map;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Node("Database")
public class DatabaseNode extends ComponentNode {

    private DatabaseTechnology technology;
    private String hostname;
    @CompositeProperty
    private Map<String, Object> properties;

}
