package com.pcrt.softgraph.repository;

import com.pcrt.softgraph.model.entity.component.ComponentEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface ComponentRepository extends JpaRepositoryImplementation<ComponentEntity, Long> {
}
