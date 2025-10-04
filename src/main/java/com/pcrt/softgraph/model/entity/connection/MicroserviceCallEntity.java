package com.pcrt.softgraph.model.entity.connection;

import com.pcrt.softgraph.model.entity.component.ComponentEntity;
import com.pcrt.softgraph.model.entity.component.MicroserviceEntity;
import com.pcrt.softgraph.model.model.connection.ConnectionType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@DiscriminatorValue(ConnectionType.Types.MICROSERVICE_CALL)
public class MicroserviceCallEntity extends ConnectionEntity {

    @Column(name = "microservice_endpoint")
    private String endpoint;
    @Column(name = "id_source")
    private Long idCaller;
    @Column(name = "id_target")
    private Long idMicroservice;

    @JoinColumn(name = "id_source", insertable=false, updatable=false)
    @ManyToOne
    private ComponentEntity caller;
    @JoinColumn(name = "id_target", insertable=false, updatable=false)
    @ManyToOne
    private MicroserviceEntity microservice;

}
