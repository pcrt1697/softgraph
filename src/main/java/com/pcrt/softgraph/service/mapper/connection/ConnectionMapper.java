package com.pcrt.softgraph.service.mapper.connection;

import com.pcrt.softgraph.model.entity.connection.ConnectionEntity;
import com.pcrt.softgraph.model.input.connection.ConnectionInput;
import com.pcrt.softgraph.model.model.connection.ConnectionModel;
import com.pcrt.softgraph.service.mapper.EntityMapper;

public interface ConnectionMapper<INPUT extends ConnectionInput, ENTITY extends ConnectionEntity, MODEL extends ConnectionModel>
        extends EntityMapper<INPUT, ENTITY, MODEL> {
}
