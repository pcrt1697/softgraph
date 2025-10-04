package com.pcrt.softgraph.model.entity.connection;

import com.pcrt.softgraph.model.model.connection.ConnectionType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name="connections")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType = DiscriminatorType.STRING)
@EntityListeners(AuditingEntityListener.class)
public abstract class ConnectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private ConnectionType type;
    private String description;
    @Column(name = "id_source")
    private Long idSource;
    @Column(name = "id_target")
    private Long idTarget;
    @CreatedDate
    @Column(name = "ts_create")
    private Instant tsCreate;
    @LastModifiedDate
    @Column(name = "ts_update")
    private Instant tsUpdate;
}
