package com.pcrt.softgraph.repository;

import com.pcrt.softgraph.model.node.microservice.MicroserviceNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicroserviceRepository extends Neo4jRepository<MicroserviceNode, Long>, Neo4jProjectionRepository<Long, MicroserviceNode> {
}
