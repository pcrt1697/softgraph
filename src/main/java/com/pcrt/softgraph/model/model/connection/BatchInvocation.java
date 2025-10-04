package com.pcrt.softgraph.model.model.connection;

import com.pcrt.softgraph.model.model.component.Batch;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Representation of a batch invocation connection")
public class BatchInvocation extends ConnectionModel {
    private Integer order;
    private Batch invoker;
    private Batch batch;
}
