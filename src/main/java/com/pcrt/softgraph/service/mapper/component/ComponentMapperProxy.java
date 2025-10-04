package com.pcrt.softgraph.service.mapper.component;

import com.pcrt.softgraph.exception.BaseException;
import com.pcrt.softgraph.model.entity.component.BatchEntity;
import com.pcrt.softgraph.model.entity.component.ComponentEntity;
import com.pcrt.softgraph.model.entity.component.DatabaseEntity;
import com.pcrt.softgraph.model.entity.component.MicroserviceEntity;
import com.pcrt.softgraph.model.input.component.BatchInput;
import com.pcrt.softgraph.model.input.component.ComponentInput;
import com.pcrt.softgraph.model.input.component.DatabaseInput;
import com.pcrt.softgraph.model.input.component.MicroserviceInput;
import com.pcrt.softgraph.model.model.component.ComponentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComponentMapperProxy {

    @Autowired
    private BatchMapper batchMapper;
    @Autowired
    private MicroserviceMapper microserviceMapper;
    @Autowired
    private DatabaseMapper databaseMapper;

    public ComponentEntity toEntity(ComponentInput input) {
        switch (input.getType()) {
            case BATCH -> {
                return batchMapper.toEntity((BatchInput) input);
            }
            case DATABASE -> {
                return databaseMapper.toEntity((DatabaseInput) input);
            }
            case MICROSERVICE -> {
                return microserviceMapper.toEntity((MicroserviceInput) input);
            }
            default -> throw new BaseException("Unable to map component of type %s", input.getType());
        }
    }

    public ComponentModel toModel(ComponentEntity entity) {
        switch (entity.getType()) {
            case BATCH -> {
                return batchMapper.toModel((BatchEntity) entity);
            }
            case DATABASE -> {
                return databaseMapper.toModel((DatabaseEntity) entity);
            }
            case MICROSERVICE -> {
                return microserviceMapper.toModel((MicroserviceEntity) entity);
            }
            default -> throw new BaseException("Unable to map component of type %s", entity.getType());
        }
    }

    public List<ComponentModel> toModel(List<ComponentEntity> entities) {
        return entities.stream().map(this::toModel).toList();
    }

}
