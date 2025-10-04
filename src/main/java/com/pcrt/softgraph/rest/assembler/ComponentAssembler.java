package com.pcrt.softgraph.rest.assembler;

import com.pcrt.softgraph.model.model.component.ComponentModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ComponentAssembler implements RepresentationModelAssembler<ComponentModel, EntityModel<ComponentModel>> {

    @Override
    @NonNull
    public EntityModel<ComponentModel> toModel(@NonNull ComponentModel model) {
        return EntityModel.of(model, this.getLinks());
    }

    private List<Link> getLinks() {
        return new ArrayList<>();
    }

}
