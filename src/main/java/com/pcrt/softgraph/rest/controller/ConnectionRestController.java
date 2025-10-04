package com.pcrt.softgraph.rest.controller;

import com.pcrt.softgraph.model.input.connection.ConnectionInput;
import com.pcrt.softgraph.model.model.connection.ConnectionModel;
import com.pcrt.softgraph.model.query.ConnectionQuery;
import com.pcrt.softgraph.rest.assembler.ConnectionAssembler;
import com.pcrt.softgraph.service.ConnectionService;
import com.pcrt.softgraph.validation.AllowedSortFields;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "/v1/connections"
)
@Tag(name = "connection")
public class ConnectionRestController {

    @Autowired
    private ConnectionService service;
    @Autowired
    private ConnectionAssembler assembler;
    @Autowired
    private PagedResourcesAssembler<ConnectionModel> pagedAssembler;

    @GetMapping("/{id}")
    @Operation(summary = "Fetch a connection")
    public ResponseEntity<EntityModel<ConnectionModel>> fetch(
            @PathVariable Long id
    ) {
        ConnectionModel model = service.findByIdOrThrow(id);
        return ResponseEntity.ok(assembler.toModel(model));
    }

    @PostMapping
    @Operation(summary = "Create new connection")
    public ResponseEntity<EntityModel<ConnectionModel>> create(
            @Validated @RequestBody ConnectionInput input
    ) {
        ConnectionModel model = service.create(input);
        return ResponseEntity.ok(assembler.toModel(model));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a connection")
    public ResponseEntity<?> delete(
            @PathVariable Long id
    ) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    @Operation(summary = "Search connections", description = "Get a page of software connections. Optionally, some filters can be applied. Allowed sort fields are: id, ts_create")
    public ResponseEntity<PagedModel<EntityModel<ConnectionModel>>> search(
            @ParameterObject ConnectionQuery query,
            @Validated @ParameterObject @AllowedSortFields(value = {"id", "ts_create"}) @PageableDefault(size = 20, sort = "id,DESC") Pageable pageable
    ) {
        Page<ConnectionModel> page = service.search(query, pageable);
        return ResponseEntity.ok(
                pagedAssembler.toModel(page, assembler)
        );
    }

}
