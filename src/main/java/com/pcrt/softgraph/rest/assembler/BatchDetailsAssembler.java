package com.pcrt.softgraph.rest.assembler;

import com.pcrt.softgraph.model.entity.batch.BatchDetails;
import com.pcrt.softgraph.rest.resource.BatchDetailsResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

@Component
public class BatchDetailsAssembler extends EntityModelAssembler<BatchDetailsResource> {

    @Autowired
    private BatchAssembler batchAssembler;
    @Autowired
    private DatabaseConnectionAssembler databaseConnectionAssembler;
    @Autowired
    private BatchInvocationAssembler batchInvocationAssembler;
    @Autowired
    private MicroserviceCallAssembler microserviceCallAssembler;

    public EntityModel<BatchDetailsResource> entityToModel(BatchDetails batchDetails) {
        BatchDetailsResource resource = new BatchDetailsResource();
        resource.setBatch(batchAssembler.toModel(batchDetails.getBatch()));
        resource.setBatches(batchInvocationAssembler.toCollectionModel(batchDetails.getInvokedBatches()));
        resource.setDatabases(databaseConnectionAssembler.toCollectionModel(batchDetails.getDatabaseConnections()));
        resource.setMicroservices(microserviceCallAssembler.toCollectionModel(batchDetails.getMicroserviceCalls()));
        return this.toModel(resource);
    }
}
