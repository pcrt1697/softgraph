package com.pcrt.softgraph.service.mapper.component;

import com.pcrt.softgraph.model.entity.component.DatabaseEntity;
import com.pcrt.softgraph.model.input.component.DatabaseInput;
import com.pcrt.softgraph.model.model.component.Database;
import org.mapstruct.Mapper;

@Mapper
public interface DatabaseMapper extends ComponentMapper<DatabaseInput, DatabaseEntity, Database> {

}
