package com.pcrt.softgraph.rest.resource;

import com.pcrt.softgraph.model.entity.batch.BatchEntity;
import com.pcrt.softgraph.model.entity.batch.BatchInvocationEntity;
import com.pcrt.softgraph.model.entity.database.DatabaseConnectionEntity;
import com.pcrt.softgraph.model.entity.microservice.MicroserviceCallEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

@Getter
@Setter
public class BatchDetailsResource {
    private EntityModel<BatchEntity> batch;
    private CollectionModel<EntityModel<BatchInvocationEntity>> batches;
    private CollectionModel<EntityModel<DatabaseConnectionEntity>> databases;
    private CollectionModel<EntityModel<MicroserviceCallEntity>> microservices;
}
