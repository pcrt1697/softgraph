package com.pcrt.softgraph.service.mapper.connection;

import com.pcrt.softgraph.model.entity.connection.MicroserviceCallEntity;
import com.pcrt.softgraph.model.input.connection.MicroserviceCallInput;
import com.pcrt.softgraph.model.model.connection.MicroserviceCall;
import org.mapstruct.Mapper;

@Mapper
public interface MicroserviceCallMapper extends ConnectionMapper<MicroserviceCallInput, MicroserviceCallEntity, MicroserviceCall> {
}
