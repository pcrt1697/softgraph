package com.pcrt.softgraph.model.input.component;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.pcrt.softgraph.model.model.component.ComponentType;
import io.swagger.v3.oas.annotations.media.DiscriminatorMapping;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        visible = true,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BatchInput.class, name = ComponentType.Types.BATCH),
        @JsonSubTypes.Type(value = DatabaseInput.class, name = ComponentType.Types.DATABASE),
        @JsonSubTypes.Type(value = MicroserviceInput.class, name = ComponentType.Types.MICROSERVICE),
})
@Schema(
        description = "Base object used to create a new component",
        discriminatorProperty = "type",
        discriminatorMapping = {
                @DiscriminatorMapping(value = ComponentType.Types.BATCH, schema = BatchInput.class),
                @DiscriminatorMapping(value = ComponentType.Types.DATABASE, schema = DatabaseInput.class),
                @DiscriminatorMapping(value = ComponentType.Types.MICROSERVICE, schema = MicroserviceInput.class)
        }
)
@ToString
@EqualsAndHashCode
public abstract class ComponentInput {
    @NotNull
    private ComponentType type;
    @NotEmpty
    private String name;
    private String documentationUrl;
    private String description;
}
