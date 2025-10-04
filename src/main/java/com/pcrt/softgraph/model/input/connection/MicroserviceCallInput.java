package com.pcrt.softgraph.model.input.connection;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Object used to create a new microservice call connection")
public class MicroserviceCallInput extends ConnectionInput {
    @NotNull
    @Schema(description = "Identifier of the called microservice")
    private Long idTarget;
    @NotNull
    @Schema(description = "Identifier of the source microservice")
    private Long idSource;
    private String endpoint;
}
