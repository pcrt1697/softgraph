package com.pcrt.softgraph.service.database;

import com.pcrt.softgraph.model.entity.database.DatabaseConnectionEntity;
import com.pcrt.softgraph.model.entity.database.DatabaseOperation;
import com.pcrt.softgraph.model.node.database.DatabaseConnectionRelationship;
import com.pcrt.softgraph.model.node.database.DatabaseNode;
import com.pcrt.softgraph.service.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring")
public abstract class DatabaseConnectionMapper implements EntityMapper<DatabaseConnectionRelationship, DatabaseConnectionEntity> {

    @Autowired
    protected DatabaseMapper databaseMapper;

    @Mapping(target = "id", ignore = true)
    public abstract DatabaseConnectionRelationship toRelationship(DatabaseOperation operation, String entityName, Map<String, Object> properties, DatabaseNode database);

    @Mapping(target = "database", expression = "java(databaseMapper.toEntity(relationship.getDatabase()))")
    public abstract DatabaseConnectionEntity toEntity(DatabaseConnectionRelationship relationship);

    public abstract List<DatabaseConnectionEntity> toEntities(List<DatabaseConnectionRelationship> relationship);

}
