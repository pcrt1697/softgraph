package com.pcrt.softgraph.service.microservice;

import com.pcrt.softgraph.exception.ResourceNotFoundException;
import com.pcrt.softgraph.model.entity.microservice.MicroserviceEntity;
import com.pcrt.softgraph.model.input.MicroserviceInput;
import com.pcrt.softgraph.model.node.microservice.MicroserviceNode;
import com.pcrt.softgraph.model.page.MicroservicePageQuery;
import com.pcrt.softgraph.repository.MicroserviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MicroserviceService {

    @Autowired
    private MicroserviceRepository repository;
    @Autowired
    private MicroserviceMapper mapper;

    public MicroserviceEntity findByIdOrThrow(Long id) {
        return this.findByIdOrThrow(id, MicroserviceEntity.class);
    }

    <T> T findByIdOrThrow(Long id, Class<T> projection) {
        return repository.findById(id, projection)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public MicroserviceEntity create(MicroserviceInput input) {
        MicroserviceNode node = mapper.toNode(input);
        node = repository.save(node);
        return mapper.toEntity(node);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        repository.deleteById(id);
    }

    public Page<MicroserviceEntity> search(MicroservicePageQuery pageQuery, Pageable pageable) {
        return repository.findBy(pageQuery.toExample(), pageable, MicroserviceEntity.class);
    }

}
