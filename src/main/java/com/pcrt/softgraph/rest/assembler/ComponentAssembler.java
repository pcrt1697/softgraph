package com.pcrt.softgraph.rest.assembler;

import com.pcrt.softgraph.model.model.component.ComponentModel;
import com.pcrt.softgraph.rest.controller.ComponentRestController;
import com.pcrt.softgraph.rest.controller.ConnectionRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ComponentAssembler implements RepresentationModelAssembler<ComponentModel, EntityModel<ComponentModel>> {

    @Override
    @NonNull
    public EntityModel<ComponentModel> toModel(@NonNull ComponentModel model) {
        return EntityModel.of(model, this.getLinks(model));
    }

    private List<Link> getLinks(ComponentModel model) {
        List<Link> links = new ArrayList<>();
        links.add(
                WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(ComponentRestController.class).fetch(model.getId())
                ).withSelfRel()
        );
        links.add(
                WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(ConnectionRestController.class).search(null, null)
                ).withRel("connections")
        );
        return links;
    }

}
