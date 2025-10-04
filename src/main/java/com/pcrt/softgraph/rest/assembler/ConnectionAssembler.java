package com.pcrt.softgraph.rest.assembler;

import com.pcrt.softgraph.model.model.connection.ConnectionModel;
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
public class ConnectionAssembler implements RepresentationModelAssembler<ConnectionModel, EntityModel<ConnectionModel>> {

    @Override
    @NonNull
    public EntityModel<ConnectionModel> toModel(@NonNull ConnectionModel model) {
        return EntityModel.of(model, this.getLinks(model));
    }

    private List<Link> getLinks(ConnectionModel model) {
        List<Link> links = new ArrayList<>();
        links.add(
                WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(ConnectionRestController.class).fetch(model.getId())
                ).withSelfRel()
        );
        links.add(
                WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(ComponentRestController.class).fetch(model.getIdSource())
                ).withRel("source")
        );
        links.add(
                WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(ComponentRestController.class).fetch(model.getIdTarget())
                ).withRel("target")
        );
        return links;
    }

}
