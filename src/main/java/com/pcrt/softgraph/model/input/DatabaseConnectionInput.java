package com.pcrt.softgraph.model.input;

import com.pcrt.softgraph.model.entity.database.DatabaseOperation;
import com.pcrt.softgraph.validation.NotEmptyCollection;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DatabaseConnectionInput {

    @NotNull
    @NotEmptyCollection
    private List<@NotNull Item> databases;

    @Getter
    @Setter
    @Schema(name = "DatabaseConnectionInput.Item")
    public static class Item {
        @NotNull
        private Long idDatabase;
        private DatabaseOperation operation;
        private String entityName;
    }
}
