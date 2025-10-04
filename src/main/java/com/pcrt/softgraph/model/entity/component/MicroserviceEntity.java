package com.pcrt.softgraph.model.entity.component;

import com.pcrt.softgraph.model.model.component.ComponentType;
import com.pcrt.softgraph.model.model.ProgrammingLanguage;
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
@DiscriminatorValue(ComponentType.Types.MICROSERVICE)
public class MicroserviceEntity extends ComponentEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "programming_language")
    private ProgrammingLanguage programmingLanguage;
    @Column(name = "repository_url")
    private String repositoryUrl;
    @Column(name = "service_url")
    private String serviceUrl;
}
