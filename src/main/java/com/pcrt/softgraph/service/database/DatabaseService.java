package com.pcrt.softgraph.service.database;

import com.pcrt.softgraph.exception.ResourceNotFoundException;
import com.pcrt.softgraph.model.entity.database.DatabaseEntity;
import com.pcrt.softgraph.model.input.DatabaseConnectionInput;
import com.pcrt.softgraph.model.input.DatabaseInput;
import com.pcrt.softgraph.model.node.database.DatabaseConnectionRelationship;
import com.pcrt.softgraph.model.node.database.DatabaseNode;
import com.pcrt.softgraph.model.page.DatabasePageQuery;
import com.pcrt.softgraph.repository.DatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseService {

    @Autowired
    private DatabaseRepository repository;
    @Autowired
    private DatabaseMapper mapper;
    @Autowired
    private DatabaseConnectionMapper connectionMapper;

    public DatabaseEntity findByIdOrThrow(Long id) {
        return this.findByIdOrThrow(id, DatabaseEntity.class);
    }

    <T> T findByIdOrThrow(Long id, Class<T> projection) {
        return repository.findById(id, projection)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public DatabaseEntity create(DatabaseInput input) {
        DatabaseNode node = mapper.toNode(input);
        node = repository.save(node);
        return mapper.toEntity(node);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        repository.deleteById(id);
    }

    public Page<DatabaseEntity> search(DatabasePageQuery pageQuery, Pageable pageable) {
        return repository.findBy(pageQuery.toExample(), pageable, DatabaseEntity.class);
    }

    public List<DatabaseConnectionRelationship> createDatabaseConnection(DatabaseConnectionInput input) {
        return input.getDatabases().stream().map(
                item -> connectionMapper.toRelationship(
                        item.getOperation(),
                        item.getEntityName(),
                        item.getProperties(),
                        this.findByIdOrThrow(item.getIdDatabase(), DatabaseNode.class)
                )
        ).toList();
    }

}
