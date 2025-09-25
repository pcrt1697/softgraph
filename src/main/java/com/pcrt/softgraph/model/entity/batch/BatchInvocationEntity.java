package com.pcrt.softgraph.model.entity.batch;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class BatchInvocationEntity {
    private Long id;
    private Integer order;
    private Map<String, Object> properties;
    private BatchEntity batch;
}
