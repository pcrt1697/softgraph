package com.pcrt.softgraph.service.mapper.connection;

import com.pcrt.softgraph.model.entity.component.ComponentEntity;
import com.pcrt.softgraph.model.entity.connection.MicroserviceCallEntity;
import com.pcrt.softgraph.model.input.connection.MicroserviceCallInput;
import com.pcrt.softgraph.model.model.component.ComponentModel;
import com.pcrt.softgraph.model.model.connection.MicroserviceCall;
import com.pcrt.softgraph.service.mapper.component.ComponentMapperProxy;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class MicroserviceCallMapper implements ConnectionMapper<MicroserviceCallInput, MicroserviceCallEntity, MicroserviceCall> {

    @Autowired
    protected ComponentMapperProxy componentMapper;

    ComponentModel map(ComponentEntity entity) {
        return componentMapper.toModel(entity);
    }

}
