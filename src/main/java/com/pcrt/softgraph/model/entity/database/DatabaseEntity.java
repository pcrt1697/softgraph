package com.pcrt.softgraph.model.entity.database;

import com.pcrt.softgraph.model.entity.ComponentEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DatabaseEntity extends ComponentEntity {

    private DatabaseTechnology technology;
    private String hostname;
    private Map<String, Object> properties;

}
