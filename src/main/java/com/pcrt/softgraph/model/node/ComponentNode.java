package com.pcrt.softgraph.model.node;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.Instant;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Node("Component")
public abstract class ComponentNode {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String documentationUrl;
    private String description;
    @CreatedDate
    private Instant tsCreate;
    @LastModifiedDate
    private Instant tsUpdate;
}
