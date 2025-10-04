package com.pcrt.softgraph.rest.assembler;

import com.pcrt.softgraph.model.model.connection.ConnectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConnectionAssembler implements RepresentationModelAssembler<ConnectionModel, EntityModel<ConnectionModel>> {

    @Override
    @NonNull
    public EntityModel<ConnectionModel> toModel(@NonNull ConnectionModel model) {
        return EntityModel.of(model, this.getLinks());
    }

    private List<Link> getLinks() {
        return new ArrayList<>();
    }

}
