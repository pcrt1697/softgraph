package com.pcrt.softgraph.rest.controller;

import com.pcrt.softgraph.model.input.component.ComponentInput;
import com.pcrt.softgraph.model.model.component.ComponentModel;
import com.pcrt.softgraph.model.query.ComponentQuery;
import com.pcrt.softgraph.rest.assembler.ComponentAssembler;
import com.pcrt.softgraph.service.ComponentService;
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
        value = "/v1/components"
)
@Tag(name = "component")
public class ComponentRestController {

    @Autowired
    private ComponentService service;
    @Autowired
    private ComponentAssembler assembler;
    @Autowired
    private PagedResourcesAssembler<ComponentModel> pagedAssembler;

    @GetMapping("/{id}")
    @Operation(summary = "Fetch a software component")
    public ResponseEntity<EntityModel<ComponentModel>> fetch(
            @PathVariable Long id
    ) {
        ComponentModel model = service.findByIdOrThrow(id);
        return ResponseEntity.ok(assembler.toModel(model));
    }

    @PostMapping
    @Operation(summary = "Create new software component")
    public ResponseEntity<EntityModel<ComponentModel>> create(
            @Validated @RequestBody ComponentInput input
    ) {
        ComponentModel model = service.create(input);
        return ResponseEntity.ok(assembler.toModel(model));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a software component")
    public ResponseEntity<?> delete(
            @PathVariable Long id
    ) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    @Operation(summary = "Search components", description = "Get a page of software components. Optionally, some filters can be applied. Allowed sort fields are: id, ts_create")
    public ResponseEntity<PagedModel<EntityModel<ComponentModel>>> search(
            @ParameterObject ComponentQuery query,
            @Validated @ParameterObject @AllowedSortFields(value = {"id", "ts_create"}) @PageableDefault(size = 20, sort = "id,DESC") Pageable pageable
    ) {
        Page<ComponentModel> page = service.search(query, pageable);
        return ResponseEntity.ok(
                pagedAssembler.toModel(page, assembler)
        );
    }

}
