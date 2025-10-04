package com.pcrt.softgraph.service.mapper.connection;

import com.pcrt.softgraph.exception.BaseException;
import com.pcrt.softgraph.model.entity.connection.BatchInvocationEntity;
import com.pcrt.softgraph.model.entity.connection.ConnectionEntity;
import com.pcrt.softgraph.model.entity.connection.DatabaseConnectionEntity;
import com.pcrt.softgraph.model.entity.connection.MicroserviceCallEntity;
import com.pcrt.softgraph.model.input.connection.BatchInvocationInput;
import com.pcrt.softgraph.model.input.connection.ConnectionInput;
import com.pcrt.softgraph.model.input.connection.DatabaseConnectionInput;
import com.pcrt.softgraph.model.input.connection.MicroserviceCallInput;
import com.pcrt.softgraph.model.model.connection.ConnectionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConnectionMapperProxy {

    @Autowired
    private BatchInvocationMapper batchInvocationMapper;
    @Autowired
    private MicroserviceCallMapper microserviceCallMapper;
    @Autowired
    private DatabaseConnectionMapper databaseConnectionMapper;

    public ConnectionEntity toEntity(ConnectionInput input) {
        switch (input.getType()) {
            case BATCH_INVOCATION -> {
                return batchInvocationMapper.toEntity((BatchInvocationInput) input);
            }
            case DATABASE_CONNECTION -> {
                return databaseConnectionMapper.toEntity((DatabaseConnectionInput) input);
            }
            case MICROSERVICE_CALL -> {
                return microserviceCallMapper.toEntity((MicroserviceCallInput) input);
            }
            default -> throw new BaseException("Unable to map connection of type %s", input.getType());
        }
    }

    public ConnectionModel toModel(ConnectionEntity entity) {
        switch (entity.getType()) {
            case BATCH_INVOCATION -> {
                return batchInvocationMapper.toModel((BatchInvocationEntity) entity);
            }
            case DATABASE_CONNECTION -> {
                return databaseConnectionMapper.toModel((DatabaseConnectionEntity) entity);
            }
            case MICROSERVICE_CALL -> {
                return microserviceCallMapper.toModel((MicroserviceCallEntity) entity);
            }
            default -> throw new BaseException("Unable to map connection of type %s", entity.getType());
        }
    }

    public List<ConnectionModel> toModel(List<ConnectionEntity> entities) {
        return entities.stream().map(this::toModel).toList();
    }

}
