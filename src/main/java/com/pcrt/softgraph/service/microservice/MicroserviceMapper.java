package com.pcrt.softgraph.service.microservice;

import com.pcrt.softgraph.service.EntityMapper;
import com.pcrt.softgraph.service.NodeMapper;
import com.pcrt.softgraph.model.entity.microservice.MicroserviceEntity;
import com.pcrt.softgraph.model.input.MicroserviceInput;
import com.pcrt.softgraph.model.node.microservice.MicroserviceNode;
import org.mapstruct.Mapper;

@Mapper
public interface MicroserviceMapper extends NodeMapper<MicroserviceInput, MicroserviceNode>, EntityMapper<MicroserviceNode, MicroserviceEntity> {
}
