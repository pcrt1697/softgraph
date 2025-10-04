package com.pcrt.softgraph.graphql.controller;

import com.pcrt.softgraph.graphql.search.PageDefinition;
import com.pcrt.softgraph.model.model.connection.ConnectionModel;
import com.pcrt.softgraph.model.query.ConnectionQuery;
import com.pcrt.softgraph.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

@Controller
public class ConnectionGraphqlController {

    @Autowired
    private ConnectionService connectionService;

    @QueryMapping
    public ConnectionModel connection(@Argument Long id) {
        return connectionService.findByIdOrThrow(id);
    }

    @QueryMapping
    public Page<ConnectionModel> searchConnections(@Argument ConnectionQuery query, @Validated @Argument PageDefinition page) {
        return connectionService.search(
                query == null ? new ConnectionQuery() : query,
                page.toPageable()
        );
    }

}
