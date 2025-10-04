package com.pcrt.softgraph.service.mapper.component;

import com.pcrt.softgraph.model.entity.component.BatchEntity;
import com.pcrt.softgraph.model.input.component.BatchInput;
import com.pcrt.softgraph.model.model.component.Batch;
import org.mapstruct.Mapper;

@Mapper
public interface BatchMapper extends ComponentMapper<BatchInput, BatchEntity, Batch> {
}
