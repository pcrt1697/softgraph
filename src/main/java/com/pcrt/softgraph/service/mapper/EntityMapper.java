package com.pcrt.softgraph.service.mapper;

import org.mapstruct.Mapping;

public interface EntityMapper<INPUT, ENTITY, MODEL> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tsCreate", ignore = true)
    @Mapping(target = "tsUpdate", ignore = true)
    ENTITY toEntity(INPUT input);

    MODEL toModel(ENTITY entity);

}
