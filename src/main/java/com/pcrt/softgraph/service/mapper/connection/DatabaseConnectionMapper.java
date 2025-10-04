package com.pcrt.softgraph.service.mapper.connection;

import com.pcrt.softgraph.model.entity.connection.DatabaseConnectionEntity;
import com.pcrt.softgraph.model.input.connection.DatabaseConnectionInput;
import com.pcrt.softgraph.model.model.connection.DatabaseConnection;
import org.mapstruct.Mapper;

@Mapper
public interface DatabaseConnectionMapper extends ConnectionMapper<DatabaseConnectionInput, DatabaseConnectionEntity, DatabaseConnection> {
}
