package com.pcrt.softgraph.rest.controller;

import com.pcrt.softgraph.model.entity.batch.BatchEntity;
import com.pcrt.softgraph.model.entity.batch.BatchInvocationEntity;
import com.pcrt.softgraph.model.input.BatchInput;
import com.pcrt.softgraph.model.input.BatchInvocationInput;
import com.pcrt.softgraph.model.page.BatchPageQuery;
import com.pcrt.softgraph.rest.assembler.BatchAssembler;
import com.pcrt.softgraph.rest.assembler.BatchInvocationAssembler;
import com.pcrt.softgraph.rest.openapi.ApiResponsesMixin;
import com.pcrt.softgraph.service.batch.BatchService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "/v1/batches"
)
@Tag(name = "batch")
public class BatchController {

    @Autowired
    private BatchService batchService;
    @Autowired
    private BatchAssembler batchAssembler;
    @Autowired
    private BatchInvocationAssembler invocationAssembler;
    @Autowired
    protected PagedResourcesAssembler<BatchEntity> batchPageAssembler;
    @Autowired
    protected PagedResourcesAssembler<BatchInvocationEntity> batchInvocationPageAssembler;

    @GetMapping("/{id}")
    @Operation(summary = "Find batch application by ID")
    @ApiResponsesMixin
    public ResponseEntity<EntityModel<BatchEntity>> findById(
            @PathVariable Long id
    ) {
        BatchEntity entity = batchService.findByIdOrThrow(id);
        EntityModel<BatchEntity> entityModel = batchAssembler.toModel(entity);
        return ResponseEntity.ok(entityModel);
    }

    @PostMapping()
    @Operation(summary = "Create new batch application")
    @ApiResponsesMixin
    public ResponseEntity<EntityModel<BatchEntity>> create(
            @Validated @RequestBody BatchInput input
    ) {
        BatchEntity entity = batchService.create(input);
        EntityModel<BatchEntity> entityModel = batchAssembler.toModel(entity);
        return ResponseEntity.ok(entityModel);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete batch application by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Operation completed successfully"),
            @ApiResponse(responseCode = "500", description = "An unexpected error occurred")
    })
    public ResponseEntity<?> deleteById(
            @PathVariable Long id
    ) {
        batchService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    @Operation(summary = "Search batch resources", description = "Get a page of batch applications. Optionally, some filters can be applied. Allowed sort fields are: id, tsCreate")
    @ApiResponsesMixin
    public ResponseEntity<PagedModel<EntityModel<BatchEntity>>> search(
            @Validated @ParameterObject BatchPageQuery pageQuery, @Validated @AllowedSortFields(value = {"id", "tsCreate"}) @ParameterObject @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<BatchEntity> page = batchService.search(pageQuery, pageable);
        return ResponseEntity.ok(batchPageAssembler.toModel(page, this.batchAssembler));
    }

    @GetMapping("/{id}/batch-invocations")
    @Operation(summary = "Search batch invocations", description = "Search batch applications invoked by the resource. Results are sorted by: order and id.")
    public ResponseEntity<PagedModel<EntityModel<BatchInvocationEntity>>> searchBatchInvocations(
            @PathVariable Long id, @RequestParam Integer pageSize, @RequestParam Integer pageNumber, @RequestParam(defaultValue = "ASC") Sort.Direction sortDirection
    ) {
        Page<BatchInvocationEntity> page = batchService.searchInvocations(id, pageNumber, pageSize, sortDirection);
        return ResponseEntity.ok(batchInvocationPageAssembler.toModel(page, invocationAssembler));
    }

    @PostMapping("/{id}/batch-invocations")
    @Operation(summary = "Add batch invocations", description = "Add invoked batch applications to the resource")
    public ResponseEntity<?> addBatchInvocations(
            @PathVariable Long id, @Validated @RequestBody BatchInvocationInput input
    ) {
        batchService.addBatchInvocations(id, input);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/batch-invocations/{id}")
    @Operation(summary = "Delete batch invocation")
    public ResponseEntity<?> deleteBatchInvocation(
            @PathVariable Long id
    ) {
        batchService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
