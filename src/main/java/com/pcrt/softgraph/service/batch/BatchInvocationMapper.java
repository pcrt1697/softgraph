package com.pcrt.softgraph.service.batch;

import com.pcrt.softgraph.model.entity.batch.BatchInvocationEntity;
import com.pcrt.softgraph.model.node.batch.BatchInvocationRelationship;
import com.pcrt.softgraph.model.node.batch.BatchNode;
import com.pcrt.softgraph.service.EntityMapper;
import com.pcrt.softgraph.utils.PageUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring")
public abstract class BatchInvocationMapper implements EntityMapper<BatchInvocationRelationship, BatchInvocationEntity> {

    @Autowired
    protected BatchMapper batchMapper;

    @Mapping(target = "id", ignore = true)
    public abstract BatchInvocationRelationship toRelationship(Integer order, Map<String, Object> properties, BatchNode batch);

    @Mapping(target = "batch", expression = "java(batchMapper.toEntity(relationship.getBatch()))")
    public abstract BatchInvocationEntity toEntity(BatchInvocationRelationship relationship);

    public abstract List<BatchInvocationEntity> toEntities(List<BatchInvocationRelationship> relationship);

    public Page<BatchInvocationEntity> toEntityPage(List<BatchInvocationRelationship> relationships, Integer pageNumber, Integer pageSize, Sort.Direction sortDirection) {
        Comparator<Integer> comparator = sortDirection.isDescending() ?
                Comparator.reverseOrder() :
                Comparator.naturalOrder();
        List<BatchInvocationEntity> entities = this.toEntities(relationships).stream()
                .sorted(
                        Comparator.comparing(BatchInvocationEntity::getOrder, comparator)
                                .thenComparing(BatchInvocationEntity::getId)
                )
                .toList();
        return PageUtils.getPage(entities, Pageable.ofSize(pageSize).withPage(pageNumber));
    }

}
