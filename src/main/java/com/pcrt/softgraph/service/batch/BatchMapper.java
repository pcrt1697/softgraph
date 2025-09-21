package com.pcrt.softgraph.service.batch;

import com.pcrt.softgraph.service.EntityMapper;
import com.pcrt.softgraph.service.NodeMapper;
import com.pcrt.softgraph.model.entity.batch.BatchEntity;
import com.pcrt.softgraph.model.input.BatchInput;
import com.pcrt.softgraph.model.node.batch.BatchNode;
import org.mapstruct.Mapper;

@Mapper
public interface BatchMapper extends NodeMapper<BatchInput, BatchNode>, EntityMapper<BatchNode, BatchEntity> {
    
}
