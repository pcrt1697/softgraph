package com.pcrt.softgraph.repository;

import com.pcrt.softgraph.model.node.database.DatabaseNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseRepository extends Neo4jRepository<DatabaseNode, Long>, Neo4jProjectionRepository<Long, DatabaseNode> {
}
