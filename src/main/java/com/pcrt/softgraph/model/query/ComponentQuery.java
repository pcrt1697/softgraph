package com.pcrt.softgraph.model.query;

import com.pcrt.softgraph.model.entity.component.BatchEntity;
import com.pcrt.softgraph.model.entity.component.ComponentEntity;
import com.pcrt.softgraph.model.entity.component.DatabaseEntity;
import com.pcrt.softgraph.model.entity.component.MicroserviceEntity;
import com.pcrt.softgraph.model.model.DatabaseTechnology;
import com.pcrt.softgraph.model.model.ProgrammingLanguage;
import com.pcrt.softgraph.model.model.component.ComponentType;
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
public class ComponentQuery implements Specification<ComponentEntity> {

    @Schema(description = "Filter by component name (using like operator with `%`).")
    private String name;
    @Schema(description = "Filter by component type.")
    private ComponentType type;
    @Schema(description = "Filter by programming language.")
    private ProgrammingLanguage programmingLanguage;
    @Schema(description = "Filter by cron expression (using like operator with `%`).")
    private String cronExpression;
    @Schema(description = "Filter by database technology.")
    private DatabaseTechnology databaseTechnology;
    @Schema(description = "Filter by service url (using like operator with `%`).")
    private String serviceUrl;

    @Override
    @NonNull
    public Predicate toPredicate(@NonNull Root<ComponentEntity> root, @NonNull CriteriaQuery<?> query, @NonNull CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (StringUtils.isNotEmpty(this.name)) {
            predicates.add(criteriaBuilder.like(root.get("name"), this.name));
        }
        if (this.type != null) {
            predicates.add(criteriaBuilder.equal(root.get("type"), this.type));
        }
        if (this.programmingLanguage != null) {
            predicates.add(
                    criteriaBuilder.or(
                            criteriaBuilder.equal(criteriaBuilder.treat(root, BatchEntity.class).get("programmingLanguage"), this.programmingLanguage),
                            criteriaBuilder.equal(criteriaBuilder.treat(root, MicroserviceEntity.class).get("programmingLanguage"), this.programmingLanguage)
                    )
            );
        }
        if (StringUtils.isNotEmpty(this.cronExpression)) {
            predicates.add(
                    criteriaBuilder.like(criteriaBuilder.treat(root, BatchEntity.class).get("cronExpression"), this.cronExpression)
            );
        }
        if (this.databaseTechnology != null) {
            predicates.add(
                    criteriaBuilder.equal(criteriaBuilder.treat(root, DatabaseEntity.class).get("technology"), this.databaseTechnology)
            );
        }
        if (StringUtils.isNotEmpty(this.serviceUrl)) {
            predicates.add(
                    criteriaBuilder.or(
                            criteriaBuilder.like(criteriaBuilder.treat(root, DatabaseEntity.class).get("serviceUrl"), this.serviceUrl),
                            criteriaBuilder.like(criteriaBuilder.treat(root, MicroserviceEntity.class).get("serviceUrl"), this.serviceUrl)
                            )
            );
        }
        return criteriaBuilder.and(predicates.toArray(predicates.toArray(new Predicate[0])));
    }

}
