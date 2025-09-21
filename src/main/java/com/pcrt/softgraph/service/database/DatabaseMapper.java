package com.pcrt.softgraph.service.database;

import com.pcrt.softgraph.service.EntityMapper;
import com.pcrt.softgraph.service.NodeMapper;
import com.pcrt.softgraph.model.entity.database.DatabaseEntity;
import com.pcrt.softgraph.model.input.DatabaseInput;
import com.pcrt.softgraph.model.node.database.DatabaseNode;
import org.mapstruct.Mapper;

@Mapper
public interface DatabaseMapper extends NodeMapper<DatabaseInput, DatabaseNode>, EntityMapper<DatabaseNode, DatabaseEntity> {
}
