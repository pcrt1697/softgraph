package com.pcrt.softgraph.model.entity.component;

import com.pcrt.softgraph.model.model.ProgrammingLanguage;
import com.pcrt.softgraph.model.model.component.ComponentType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue(ComponentType.Types.BATCH)
public class BatchEntity extends ComponentEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "programming_language")
    private ProgrammingLanguage programmingLanguage;
    @Column(name = "repository_url")
    private String repositoryUrl;
    @Column(name = "cron_expression")
    private String cronExpression;
}
