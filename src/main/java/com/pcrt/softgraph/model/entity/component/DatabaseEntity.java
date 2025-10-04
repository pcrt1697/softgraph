package com.pcrt.softgraph.model.entity.component;

import com.pcrt.softgraph.model.model.component.ComponentType;
import com.pcrt.softgraph.model.model.DatabaseTechnology;
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
@DiscriminatorValue(ComponentType.Types.DATABASE)
public class DatabaseEntity extends ComponentEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "database_technology")
    private DatabaseTechnology technology;
    @Column(name = "service_url")
    private String serviceUrl;
}
