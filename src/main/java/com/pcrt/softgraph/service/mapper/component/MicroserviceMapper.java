package com.pcrt.softgraph.service.mapper.component;

import com.pcrt.softgraph.model.entity.component.MicroserviceEntity;
import com.pcrt.softgraph.model.input.component.MicroserviceInput;
import com.pcrt.softgraph.model.model.component.Microservice;
import org.mapstruct.Mapper;

@Mapper
public interface MicroserviceMapper extends ComponentMapper<MicroserviceInput, MicroserviceEntity, Microservice> {

}
