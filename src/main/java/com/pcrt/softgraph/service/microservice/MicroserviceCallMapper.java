package com.pcrt.softgraph.service.microservice;

import com.pcrt.softgraph.model.entity.database.DatabaseOperation;
import com.pcrt.softgraph.model.entity.microservice.MicroserviceCallEntity;
import com.pcrt.softgraph.model.node.database.DatabaseNode;
import com.pcrt.softgraph.model.node.microservice.MicroserviceCallRelationship;
import com.pcrt.softgraph.service.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring")
public abstract class MicroserviceCallMapper implements EntityMapper<MicroserviceCallRelationship, MicroserviceCallEntity> {

    @Autowired
    protected MicroserviceMapper microserviceMapper;

    @Mapping(target = "id", ignore = true)
    public abstract MicroserviceCallRelationship toRelationship(DatabaseOperation operation, String entityName, Map<String, Object> properties, DatabaseNode database);

    @Mapping(target = "microservice", expression = "java(microserviceMapper.toEntity(relationship.getMicroservice()))")
    public abstract MicroserviceCallEntity toEntity(MicroserviceCallRelationship relationship);

    public abstract List<MicroserviceCallEntity> toEntities(List<MicroserviceCallRelationship> relationship);

}
