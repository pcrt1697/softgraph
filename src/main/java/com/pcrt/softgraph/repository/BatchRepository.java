package com.pcrt.softgraph.repository;

import com.pcrt.softgraph.model.entity.batch.BatchEntity;
import com.pcrt.softgraph.model.node.batch.BatchNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BatchRepository extends Neo4jRepository<BatchNode, Long>, Neo4jProjectionRepository<Long, BatchNode> {

    @Query(value = "MATCH (b:Batch)-[r:INVOKES WHERE id(r) = $idInvocation]->() DELETE r RETURN b;")
    Optional<BatchEntity> deleteInvocationById(Long idInvocation);
}
