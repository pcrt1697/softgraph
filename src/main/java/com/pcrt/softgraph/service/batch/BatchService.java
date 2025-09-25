package com.pcrt.softgraph.service.batch;

import com.pcrt.softgraph.exception.ResourceNotFoundException;
import com.pcrt.softgraph.model.entity.batch.BatchDetails;
import com.pcrt.softgraph.model.entity.batch.BatchEntity;
import com.pcrt.softgraph.model.entity.batch.BatchInvocationEntity;
import com.pcrt.softgraph.model.entity.database.DatabaseConnectionEntity;
import com.pcrt.softgraph.model.entity.microservice.MicroserviceCallEntity;
import com.pcrt.softgraph.model.input.BatchInput;
import com.pcrt.softgraph.model.input.BatchInvocationInput;
import com.pcrt.softgraph.model.node.batch.BatchInvocationRelationship;
import com.pcrt.softgraph.model.node.batch.BatchNode;
import com.pcrt.softgraph.model.page.BatchPageQuery;
import com.pcrt.softgraph.repository.BatchRepository;
import com.pcrt.softgraph.service.BaseService;
import com.pcrt.softgraph.service.database.DatabaseConnectionMapper;
import com.pcrt.softgraph.service.microservice.MicroserviceCallMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchService extends BaseService {

    @Autowired
    private BatchRepository batchRepository;
    @Autowired
    private BatchMapper batchMapper;
    @Autowired
    private BatchInvocationMapper invocationMapper;
    @Autowired
    private DatabaseConnectionMapper databaseConnectionMapper;
    @Autowired
    private MicroserviceCallMapper microserviceCallMapper;

    public BatchEntity findByIdOrThrow(Long id) {
        return this.findByIdOrThrow(id, BatchEntity.class);
    }

    <T> T findByIdOrThrow(Long id, Class<T> projection) {
        return batchRepository.findById(id, projection)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public BatchEntity create(BatchInput input) {
        BatchNode node = batchMapper.toNode(input);
        node = batchRepository.save(node);
        return batchMapper.toEntity(node);
    }

    public void delete(Long id) {
        if (!batchRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        batchRepository.deleteById(id);
    }

    public Page<BatchEntity> search(BatchPageQuery pageQuery, Pageable pageable) {
        return batchRepository.findBy(pageQuery.toExample(), pageable, BatchEntity.class);
    }

    public BatchDetails getDetails(Long id) {
        BatchNode node = this.findByIdOrThrow(id, BatchNode.class);
        BatchEntity entity = batchMapper.toEntity(node);
        List<BatchInvocationEntity> invocations = invocationMapper.toEntities(node.getInvokedBatches());
        List<DatabaseConnectionEntity> connections = databaseConnectionMapper.toEntities(node.getDatabaseConnections());
        List<MicroserviceCallEntity> calls = microserviceCallMapper.toEntities(node.getMicroserviceCalls());
        return batchMapper.toDetails(entity, invocations, connections, calls);
    }

    public void addBatchInvocations(Long idBatch, BatchInvocationInput input) {
        BatchNode node = this.findByIdOrThrow(idBatch, BatchNode.class);
        List<BatchInvocationRelationship> relationships = input.getBatches().stream()
                .map(
                        item -> invocationMapper.toRelationship(
                                item.getOrder(),
                                item.getProperties(),
                                this.findByIdOrThrow(item.getIdBatch(), BatchNode.class)
                        )
                )
                .toList();
        node.addBatchInvocations(relationships);
        batchRepository.save(node);
    }

    public void deleteInvocation(Long idInvocation) {
        BatchEntity entity = batchRepository.deleteInvocationById(idInvocation)
                .orElseThrow(() -> new ResourceNotFoundException(idInvocation));
        logger.info("Deleted invocation with id {} from node {}", idInvocation, entity.getId());
    }

}
