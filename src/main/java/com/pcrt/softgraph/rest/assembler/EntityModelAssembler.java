package com.pcrt.softgraph.rest.assembler;

import lombok.Getter;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;

@Getter
public class EntityModelAssembler<ENTITY> implements RepresentationModelAssembler<ENTITY, EntityModel<ENTITY>> {

    @Override
    @NonNull
    public EntityModel<ENTITY> toModel(@NonNull ENTITY entity) {
        EntityModel<ENTITY> entityModel = EntityModel.of(entity);
        this.addLinks(entityModel);
        return entityModel;
    }

    protected void addLinks(EntityModel<ENTITY> entityModel) {
        // override if needed
    }

}
