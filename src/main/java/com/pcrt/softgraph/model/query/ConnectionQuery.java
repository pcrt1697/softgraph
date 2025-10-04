package com.pcrt.softgraph.model.query;

import com.pcrt.softgraph.model.entity.connection.BatchInvocationEntity;
import com.pcrt.softgraph.model.entity.connection.ConnectionEntity;
import com.pcrt.softgraph.model.entity.connection.DatabaseConnectionEntity;
import com.pcrt.softgraph.model.entity.connection.MicroserviceCallEntity;
import com.pcrt.softgraph.model.model.DatabaseOperation;
import com.pcrt.softgraph.model.model.connection.ConnectionType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ConnectionQuery implements Specification<ConnectionEntity> {

    @Schema(description = "Filter by component type.")
    private ConnectionType type;
    @Schema(description = "Filter by batch invocation order.")
    private Integer batchOrder;
    @Schema(description = "Filter by database entity (using like operator with `%`).")
    private String databaseEntity;
    @Schema(description = "Filter by database operation.")
    private DatabaseOperation databaseOperation;
    @Schema(description = "Filter by microservice endpoint (using like operator with `%`).")
    private String microserviceEndpoint;
    @Schema(description = "Filter by connection source (i.e. batch invoker, microservice caller or database client).")
    private Long idSource;
    @Schema(description = "Filter by connection target (i.e. invoked batch, called microservice or database server).")
    private Long idTarget;

    @Override
    @NonNull
    public Predicate toPredicate(@NonNull Root<ConnectionEntity> root, @NonNull CriteriaQuery<?> query, @NonNull CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (this.type != null) {
            predicates.add(criteriaBuilder.equal(root.get("type"), this.type));
        }
        if (this.batchOrder != null) {
            predicates.add(
                    criteriaBuilder.equal(criteriaBuilder.treat(root, BatchInvocationEntity.class).get("order"), this.batchOrder)
            );
        }
        if (StringUtils.isNotEmpty(this.databaseEntity)) {
            predicates.add(
                    criteriaBuilder.equal(criteriaBuilder.treat(root, DatabaseConnectionEntity.class).get("entity"), this.databaseEntity)
            );
        }
        if (this.databaseOperation != null) {
            predicates.add(
                    criteriaBuilder.equal(criteriaBuilder.treat(root, DatabaseConnectionEntity.class).get("operation"), this.databaseOperation)
            );
        }
        if (StringUtils.isNotEmpty(this.microserviceEndpoint)) {
            predicates.add(
                    criteriaBuilder.like(criteriaBuilder.treat(root, MicroserviceCallEntity.class).get("endpoint"), this.microserviceEndpoint)
            );
        }
        if (this.idSource != null) {
            predicates.add(
                    criteriaBuilder.or(
                            criteriaBuilder.equal(criteriaBuilder.treat(root, BatchInvocationEntity.class).get("idInvoker"), this.idSource),
                            criteriaBuilder.equal(criteriaBuilder.treat(root, MicroserviceCallEntity.class).get("idCaller"), this.idSource),
                            criteriaBuilder.equal(criteriaBuilder.treat(root, DatabaseConnectionEntity.class).get("idComponent"), this.idSource)
                    )
            );
        }
        if (this.idTarget != null) {
            predicates.add(
                    criteriaBuilder.or(
                            criteriaBuilder.equal(criteriaBuilder.treat(root, BatchInvocationEntity.class).get("idBatch"), this.idTarget),
                            criteriaBuilder.equal(criteriaBuilder.treat(root, MicroserviceCallEntity.class).get("idMicroservice"), this.idTarget),
                            criteriaBuilder.equal(criteriaBuilder.treat(root, DatabaseConnectionEntity.class).get("idDatabase"), this.idTarget)
                    )
            );
        }
        return criteriaBuilder.and(predicates.toArray(predicates.toArray(new Predicate[0])));
    }

}
