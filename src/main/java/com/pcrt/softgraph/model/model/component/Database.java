package com.pcrt.softgraph.model.model.component;

import com.pcrt.softgraph.model.model.DatabaseTechnology;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Representation of a database component")
public class Database extends ComponentModel {
    private DatabaseTechnology technology;
    private String serviceUrl;
}
