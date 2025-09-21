package com.pcrt.softgraph.model.input;

import com.pcrt.softgraph.validation.NotEmptyCollection;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class BatchInvocationInput {

    @NotNull
    @NotEmptyCollection
    private List<@NotNull Item> batches;

    @Getter
    @Setter
    @Schema(name = "BatchInvocationInput.Item")
    public static class Item {
        @NotNull
        private Long idBatch;
        @Min(0)
        private Integer order;
        private Map<String, Object> parameters;
    }

}
