package com.pcrt.softgraph.model.model.connection;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.DiscriminatorMapping;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        visible = true,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BatchInvocation.class, name = ConnectionType.Types.BATCH_INVOCATION),
        @JsonSubTypes.Type(value = DatabaseConnection.class, name = ConnectionType.Types.DATABASE_CONNECTION),
        @JsonSubTypes.Type(value = MicroserviceCall.class, name = ConnectionType.Types.MICROSERVICE_CALL),
})
@Schema(
        description = "Base representation of a connection",
        discriminatorProperty = "type",
        discriminatorMapping = {
                @DiscriminatorMapping(value = ConnectionType.Types.BATCH_INVOCATION, schema = BatchInvocation.class),
                @DiscriminatorMapping(value = ConnectionType.Types.DATABASE_CONNECTION, schema = DatabaseConnection.class),
                @DiscriminatorMapping(value = ConnectionType.Types.MICROSERVICE_CALL, schema = MicroserviceCall.class)
        }
)
public abstract class ConnectionModel {
    private Long id;
    private ConnectionType type;
    private String description;
    private Long idSource;
    private Long idTarget;
    private Instant tsCreate;
    private Instant tsUpdate;
}
