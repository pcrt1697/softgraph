package com.pcrt.softgraph.model.entity.batch;

import com.pcrt.softgraph.model.entity.ComponentEntity;
import com.pcrt.softgraph.model.entity.ProgrammingLanguage;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BatchEntity extends ComponentEntity {

    private ProgrammingLanguage programmingLanguage;
    private String repositoryUrl;
    private String chronExpression;
    private Map<String, Object> properties;

}
