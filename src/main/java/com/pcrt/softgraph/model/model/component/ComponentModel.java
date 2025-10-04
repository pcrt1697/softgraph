package com.pcrt.softgraph.model.model.component;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.DiscriminatorMapping;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        visible = true,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Batch.class, name = ComponentType.Types.BATCH),
        @JsonSubTypes.Type(value = Database.class, name = ComponentType.Types.DATABASE),
        @JsonSubTypes.Type(value = Microservice.class, name = ComponentType.Types.MICROSERVICE),
})
@Schema(
        description = "Base representation of a component.",
        discriminatorProperty = "type",
        discriminatorMapping = {
                @DiscriminatorMapping(value = ComponentType.Types.BATCH, schema = Batch.class),
                @DiscriminatorMapping(value = ComponentType.Types.DATABASE, schema = Database.class),
                @DiscriminatorMapping(value = ComponentType.Types.MICROSERVICE, schema = Microservice.class)
        }
)
public abstract class ComponentModel {
    private Long id;
    private ComponentType type;
    private String name;
    private String documentationUrl;
    private String description;
    private Instant tsCreate;
    private Instant tsUpdate;
}
