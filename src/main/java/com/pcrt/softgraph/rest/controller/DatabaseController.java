package com.pcrt.softgraph.rest.controller;

import com.pcrt.softgraph.model.entity.database.DatabaseEntity;
import com.pcrt.softgraph.model.input.DatabaseInput;
import com.pcrt.softgraph.model.page.DatabasePageQuery;
import com.pcrt.softgraph.rest.assembler.DatabaseAssembler;
import com.pcrt.softgraph.rest.openapi.ApiResponsesMixin;
import com.pcrt.softgraph.service.database.DatabaseService;
import com.pcrt.softgraph.validation.AllowedSortFields;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        value = "/v1/databases"
)
@Tag(name = "database")
public class DatabaseController {

    @Autowired
    private DatabaseService service;
    @Autowired
    private DatabaseAssembler assembler;
    @Autowired
    protected PagedResourcesAssembler<DatabaseEntity> pageAssembler;

    @GetMapping("/{id}")
    @Operation(summary = "Find database by ID")
    @ApiResponsesMixin
    @ApiResponses(@ApiResponse(responseCode = "404", description = "The entity was not found"))
    public ResponseEntity<EntityModel<DatabaseEntity>> findById(
            @PathVariable Long id
    ) {
        DatabaseEntity entity = service.findByIdOrThrow(id);
        EntityModel<DatabaseEntity> entityModel = assembler.toModel(entity);
        return ResponseEntity.ok(entityModel);
    }

    @PostMapping()
    @Operation(summary = "Create new database")
    @ApiResponsesMixin
    public ResponseEntity<EntityModel<DatabaseEntity>> create(
            @Validated @RequestBody DatabaseInput input
    ) {
        DatabaseEntity entity = service.create(input);
        EntityModel<DatabaseEntity> entityModel = assembler.toModel(entity);
        return ResponseEntity.ok(entityModel);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete database by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Operation completed successfully"),
            @ApiResponse(responseCode = "500", description = "An unexpected error occurred")
    })
    public ResponseEntity<?> deleteById(
            @PathVariable Long id
    ) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    @Operation(summary = "Search database resources", description = "Get a page of databases. Optionally, some filters can be applied. Allowed sort fields are: id, tsCreate")
    @ApiResponsesMixin
    public ResponseEntity<PagedModel<EntityModel<DatabaseEntity>>> search(
            @Validated @ParameterObject DatabasePageQuery pageQuery, @Validated @AllowedSortFields(value = {"id", "tsCreate"}) @ParameterObject @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<DatabaseEntity> page = service.search(pageQuery, pageable);
        return ResponseEntity.ok(pageAssembler.toModel(page, this.assembler));
    }

}
