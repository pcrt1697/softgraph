package com.pcrt.softgraph.model.entity.batch;

import com.pcrt.softgraph.model.entity.database.DatabaseConnectionEntity;
import com.pcrt.softgraph.model.entity.microservice.MicroserviceCallEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BatchDetails {
    public BatchEntity batch;
    public List<BatchInvocationEntity> invokedBatches;
    public List<DatabaseConnectionEntity> databaseConnections;
    public List<MicroserviceCallEntity> microserviceCalls;

}
