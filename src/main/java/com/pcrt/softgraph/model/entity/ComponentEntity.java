package com.pcrt.softgraph.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public abstract class ComponentEntity {
    private Long id;
    private String name;
    private String documentationUrl;
    private String description;
    private Instant tsCreate;
    private Instant tsUpdate;
}
