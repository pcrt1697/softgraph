package com.pcrt.softgraph.service.mapper.connection;

import com.pcrt.softgraph.model.entity.connection.BatchInvocationEntity;
import com.pcrt.softgraph.model.input.connection.BatchInvocationInput;
import com.pcrt.softgraph.model.model.connection.BatchInvocation;
import org.mapstruct.Mapper;

@Mapper
public interface BatchInvocationMapper extends ConnectionMapper<BatchInvocationInput, BatchInvocationEntity, BatchInvocation> {
}
