package com.pcrt.softgraph.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface Neo4jProjectionRepository<ID, NODE> {

    <T> Page<T> findBy(Example<NODE> example, Pageable pageable, Class<T> type);
    <T> Optional<T> findById(ID id, Class<T> type);

}
