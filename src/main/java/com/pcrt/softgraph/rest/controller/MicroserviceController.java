package com.pcrt.softgraph.rest.controller;

import com.pcrt.softgraph.model.entity.microservice.MicroserviceEntity;
import com.pcrt.softgraph.model.input.MicroserviceInput;
import com.pcrt.softgraph.model.page.MicroservicePageQuery;
import com.pcrt.softgraph.rest.assembler.MicroserviceAssembler;
import com.pcrt.softgraph.rest.openapi.ApiResponsesMixin;
import com.pcrt.softgraph.service.microservice.MicroserviceService;
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
        value = "/v1/microservices"
)
@Tag(name = "microservices")
public class MicroserviceController {

    @Autowired
    private MicroserviceService service;
    @Autowired
    private MicroserviceAssembler assembler;
    @Autowired
    protected PagedResourcesAssembler<MicroserviceEntity> pageAssembler;

    @GetMapping("/{id}")
    @Operation(summary = "Find microservice by ID")
    @ApiResponsesMixin
    @ApiResponses(@ApiResponse(responseCode = "404", description = "The entity was not found"))
    public ResponseEntity<EntityModel<MicroserviceEntity>> findById(
            @PathVariable Long id
    ) {
        MicroserviceEntity entity = service.findByIdOrThrow(id);
        EntityModel<MicroserviceEntity> entityModel = assembler.toModel(entity);
        return ResponseEntity.ok(entityModel);
    }

    @PostMapping()
    @Operation(summary = "Create new microservice")
    @ApiResponsesMixin
    public ResponseEntity<EntityModel<MicroserviceEntity>> create(
            @Validated @RequestBody MicroserviceInput input
    ) {
        MicroserviceEntity entity = service.create(input);
        EntityModel<MicroserviceEntity> entityModel = assembler.toModel(entity);
        return ResponseEntity.ok(entityModel);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete microservice by ID")
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
    @Operation(summary = "Search microservice resources", description = "Get a page of microservices. Optionally, some filters can be applied. Allowed sort fields are: id, tsCreate")
    @ApiResponsesMixin
    public ResponseEntity<PagedModel<EntityModel<MicroserviceEntity>>> search(
            @Validated @ParameterObject MicroservicePageQuery pageQuery, @Validated @AllowedSortFields(value = {"id", "tsCreate"}) @ParameterObject @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<MicroserviceEntity> page = service.search(pageQuery, pageable);
        return ResponseEntity.ok(pageAssembler.toModel(page, this.assembler));
    }

}
