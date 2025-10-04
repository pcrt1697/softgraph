package com.pcrt.softgraph.graphql.controller;

import com.pcrt.softgraph.graphql.search.PageDefinition;
import com.pcrt.softgraph.model.model.component.ComponentModel;
import com.pcrt.softgraph.model.query.ComponentQuery;
import com.pcrt.softgraph.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

@Controller
public class ComponentGraphqlController {

    @Autowired
    private ComponentService componentService;

    @QueryMapping
    public ComponentModel component(@Argument Long id) {
        return componentService.findByIdOrThrow(id);
    }

    @QueryMapping
    public Page<ComponentModel> searchComponents(@Argument ComponentQuery query, @Validated @Argument PageDefinition page) {
        return componentService.search(
                query == null ? new ComponentQuery() : query,
                page.toPageable()
        );
    }

}
