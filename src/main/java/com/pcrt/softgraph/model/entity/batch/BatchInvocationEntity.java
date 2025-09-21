package com.pcrt.softgraph.model.entity.batch;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BatchInvocationEntity {
    private Long id;
    private Integer order;
    private BatchEntity batch;
}
