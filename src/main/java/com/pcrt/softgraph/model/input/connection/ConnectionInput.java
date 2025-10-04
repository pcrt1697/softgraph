package com.pcrt.softgraph.model.input.connection;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.pcrt.softgraph.model.model.connection.ConnectionType;
import io.swagger.v3.oas.annotations.media.DiscriminatorMapping;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        visible = true,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BatchInvocationInput.class, name = ConnectionType.Types.BATCH_INVOCATION),
        @JsonSubTypes.Type(value = DatabaseConnectionInput.class, name = ConnectionType.Types.DATABASE_CONNECTION),
        @JsonSubTypes.Type(value = MicroserviceCallInput.class, name = ConnectionType.Types.MICROSERVICE_CALL),
})
@Schema(
        description = "Base object used to create a new connection",
        discriminatorProperty = "type",
        discriminatorMapping = {
                @DiscriminatorMapping(value = ConnectionType.Types.BATCH_INVOCATION, schema = BatchInvocationInput.class),
                @DiscriminatorMapping(value = ConnectionType.Types.DATABASE_CONNECTION, schema = DatabaseConnectionInput.class),
                @DiscriminatorMapping(value = ConnectionType.Types.MICROSERVICE_CALL, schema = MicroserviceCallInput.class)
        }
)
public abstract class ConnectionInput {
    @NotNull
    private ConnectionType type;
    private String description;
}
