package com.pcrt.softgraph.service;

import com.pcrt.softgraph.exception.ResourceNotFoundException;
import com.pcrt.softgraph.model.entity.connection.ConnectionEntity;
import com.pcrt.softgraph.model.input.connection.ConnectionInput;
import com.pcrt.softgraph.model.model.connection.ConnectionModel;
import com.pcrt.softgraph.model.query.ConnectionQuery;
import com.pcrt.softgraph.repository.ConnectionRepository;
import com.pcrt.softgraph.service.mapper.connection.ConnectionMapperProxy;
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
public class ConnectionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionService.class);

    @Autowired
    private ConnectionRepository connectionRepository;
    @Autowired
    private ConnectionMapperProxy connectionMapper;
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public ConnectionModel create(ConnectionInput input) {
        ConnectionEntity entity = connectionMapper.toEntity(input);
        entity = connectionRepository.saveAndFlush(entity);
        entityManager.refresh(entity);
        return connectionMapper.toModel(entity);
    }

    public ConnectionModel findByIdOrThrow(Long id) {
        ConnectionEntity entity = this.findEntityByIdOrThrow(id);
        return connectionMapper.toModel(entity);
    }

    private ConnectionEntity findEntityByIdOrThrow(Long id) {
        return connectionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id)
        );
    }

    public void delete(Long id) {
        if (!connectionRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        connectionRepository.deleteById(id);
    }

    public Page<ConnectionModel> search(ConnectionQuery query, Pageable pageable) {
        Page<ConnectionEntity> page = connectionRepository.findAll(query, pageable);
        return new PageImpl<>(
                this.connectionMapper.toModel(page.getContent()),
                page.getPageable(),
                page.getTotalElements()
        );
    }

}
