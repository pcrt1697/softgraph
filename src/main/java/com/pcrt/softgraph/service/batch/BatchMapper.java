package com.pcrt.softgraph.service.batch;

import com.pcrt.softgraph.model.entity.batch.BatchDetails;
import com.pcrt.softgraph.model.entity.batch.BatchEntity;
import com.pcrt.softgraph.model.entity.batch.BatchInvocationEntity;
import com.pcrt.softgraph.model.entity.database.DatabaseConnectionEntity;
import com.pcrt.softgraph.model.entity.microservice.MicroserviceCallEntity;
import com.pcrt.softgraph.model.input.BatchInput;
import com.pcrt.softgraph.model.node.batch.BatchNode;
import com.pcrt.softgraph.service.EntityMapper;
import com.pcrt.softgraph.service.NodeMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BatchMapper extends NodeMapper<BatchInput, BatchNode>, EntityMapper<BatchNode, BatchEntity> {

    default BatchDetails toDetails(
            BatchEntity entity,
            List<BatchInvocationEntity> invocations,
            List<DatabaseConnectionEntity> connections,
            List<MicroserviceCallEntity> calls
    ) {
        BatchDetails details = new BatchDetails();
        details.setBatch(entity);
        details.setInvokedBatches(invocations);
        details.setDatabaseConnections(connections);
        details.setMicroserviceCalls(calls);
        return details;
    }
}
