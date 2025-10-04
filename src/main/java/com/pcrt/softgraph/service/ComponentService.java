package com.pcrt.softgraph.service;

import com.pcrt.softgraph.exception.ResourceNotFoundException;
import com.pcrt.softgraph.model.entity.component.ComponentEntity;
import com.pcrt.softgraph.model.input.component.ComponentInput;
import com.pcrt.softgraph.model.model.component.ComponentModel;
import com.pcrt.softgraph.model.query.ComponentQuery;
import com.pcrt.softgraph.repository.ComponentRepository;
import com.pcrt.softgraph.service.mapper.component.ComponentMapperProxy;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ComponentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComponentService.class);

    @Autowired
    private ComponentRepository componentRepository;
    @Autowired
    private ComponentMapperProxy componentMapper;
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public ComponentModel create(ComponentInput input) {
        ComponentEntity entity = componentMapper.toEntity(input);
        entity = componentRepository.saveAndFlush(entity);
        entityManager.refresh(entity);
        return componentMapper.toModel(entity);
    }

    public ComponentModel findByIdOrThrow(Long id) {
        ComponentEntity entity = this.findEntityByIdOrThrow(id);
        return componentMapper.toModel(entity);
    }

    private ComponentEntity findEntityByIdOrThrow(Long id) {
        return componentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id)
        );
    }

    public void delete(Long id) {
        if (!componentRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        componentRepository.deleteById(id);
    }

    public Page<ComponentModel> search(ComponentQuery query, Pageable pageable) {
        Page<ComponentEntity> page = componentRepository.findAll(query, pageable);
        return new PageImpl<>(
                this.componentMapper.toModel(page.getContent()),
                page.getPageable(),
                page.getTotalElements()
        );
    }
}
