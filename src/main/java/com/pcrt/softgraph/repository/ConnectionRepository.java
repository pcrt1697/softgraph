package com.pcrt.softgraph.repository;

import com.pcrt.softgraph.model.entity.connection.ConnectionEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface ConnectionRepository extends JpaRepositoryImplementation<ConnectionEntity, Long> {
}
