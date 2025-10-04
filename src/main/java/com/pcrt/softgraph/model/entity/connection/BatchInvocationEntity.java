package com.pcrt.softgraph.model.entity.connection;

import com.pcrt.softgraph.model.entity.component.BatchEntity;
import com.pcrt.softgraph.model.model.connection.ConnectionType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
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
@DiscriminatorValue(ConnectionType.Types.BATCH_INVOCATION)
public class BatchInvocationEntity extends ConnectionEntity {

    @Column(name = "batch_order")
    private Integer order;

    @JoinColumn(name = "id_source", insertable=false, updatable=false)
    @ManyToOne
    private BatchEntity invoker;
    @JoinColumn(name = "id_target", insertable=false, updatable=false)
    @ManyToOne
    private BatchEntity batch;


}
