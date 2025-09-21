package com.pcrt.softgraph.service.batch;

import com.pcrt.softgraph.model.entity.batch.BatchInvocationEntity;
import com.pcrt.softgraph.model.node.batch.BatchInvocationRelationship;
import com.pcrt.softgraph.model.node.batch.BatchNode;
import com.pcrt.softgraph.service.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring")
public abstract class BatchInvocationMapper implements EntityMapper<BatchInvocationRelationship, BatchInvocationEntity> {

    @Autowired
    protected BatchMapper batchMapper;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "batch")
    public abstract BatchInvocationRelationship toRelationship(Integer order, Map<String, Object> parameters, BatchNode batch);

    @Mapping(target = "batch", expression = "java(batchMapper.toEntity(relationship.getBatch()))")
    public abstract BatchInvocationEntity toEntity(BatchInvocationRelationship relationship);
    public abstract List<BatchInvocationEntity> toEntities(List<BatchInvocationRelationship> relationship);

}
