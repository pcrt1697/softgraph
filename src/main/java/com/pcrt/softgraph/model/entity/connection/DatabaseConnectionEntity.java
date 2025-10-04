package com.pcrt.softgraph.model.entity.connection;

import com.pcrt.softgraph.model.entity.component.ComponentEntity;
import com.pcrt.softgraph.model.entity.component.DatabaseEntity;
import com.pcrt.softgraph.model.model.DatabaseOperation;
import com.pcrt.softgraph.model.model.connection.ConnectionType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue(ConnectionType.Types.DATABASE_CONNECTION)
public class DatabaseConnectionEntity extends ConnectionEntity {

    @Column(name = "database_entity")
    private String entity;
    @Enumerated(EnumType.STRING)
    @Column(name = "database_operation")
    private DatabaseOperation operation;

    @JoinColumn(name = "id_source", insertable=false, updatable=false)
    @ManyToOne
    private ComponentEntity component;
    @JoinColumn(name = "id_target", insertable=false, updatable=false)
    @ManyToOne
    private DatabaseEntity database;

}
