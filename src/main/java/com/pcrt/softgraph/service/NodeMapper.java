package com.pcrt.softgraph.service;

import org.mapstruct.Mapping;

public interface NodeMapper<I, N> {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tsCreate", ignore = true)
    @Mapping(target = "tsUpdate", ignore = true)
    N toNode(I input);

}
