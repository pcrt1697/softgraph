package com.pcrt.softgraph.model.entity.microservice;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class MicroserviceCallEntity {
    private Long id;
    private String endpoint;
    private Map<String, Object> properties;
    private MicroserviceEntity microservice;
}
