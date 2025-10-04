package com.pcrt.softgraph.service.mapper.component;

import com.pcrt.softgraph.model.entity.component.ComponentEntity;
import com.pcrt.softgraph.model.input.component.ComponentInput;
import com.pcrt.softgraph.model.model.component.ComponentModel;
import com.pcrt.softgraph.service.mapper.EntityMapper;

public interface ComponentMapper<INPUT extends ComponentInput, ENTITY extends ComponentEntity, MODEL extends ComponentModel>
        extends EntityMapper<INPUT, ENTITY, MODEL> {
}
