package com.pcrt.softgraph.model.input.connection;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Object used to create a new batch invocation connection")
public class BatchInvocationInput extends ConnectionInput {
    @NotNull
    @Schema(description = "Identifier of the invoker batch")
    private Long idSource;
    @NotNull
    @Schema(description = "Identifier of the invoked batch")
    private Long idTarget;
    @Min(value = 0, message = "Order must be non negative")
    private Integer order;
}
