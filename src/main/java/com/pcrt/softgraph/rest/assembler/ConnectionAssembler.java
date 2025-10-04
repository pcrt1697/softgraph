package com.pcrt.softgraph.rest.assembler;

import com.pcrt.softgraph.model.model.connection.BatchInvocation;
import com.pcrt.softgraph.model.model.connection.ConnectionModel;
import com.pcrt.softgraph.model.model.connection.DatabaseConnection;
import com.pcrt.softgraph.model.model.connection.MicroserviceCall;
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
        Long idSource;
        Long idTarget;
        switch (model.getType()) {
            case MICROSERVICE_CALL -> {
                MicroserviceCall sourceModel = (MicroserviceCall) model;
                idSource = sourceModel.getCaller().getId();
                idTarget = sourceModel.getMicroservice().getId();
            }
            case DATABASE_CONNECTION -> {
                DatabaseConnection sourceModel = (DatabaseConnection) model;
                idSource = sourceModel.getComponent().getId();
                idTarget = sourceModel.getDatabase().getId();
            }
            case BATCH_INVOCATION -> {
                BatchInvocation sourceModel = (BatchInvocation) model;
                idSource = sourceModel.getInvoker().getId();
                idTarget = sourceModel.getBatch().getId();
            }
            default -> {
                return links;
            }
        }
        links.add(
                WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(ComponentRestController.class).fetch(idSource)
                ).withRel("source")
        );
        links.add(
                WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(ComponentRestController.class).fetch(idTarget)
                ).withRel("target")
        );
        return links;
    }

}
