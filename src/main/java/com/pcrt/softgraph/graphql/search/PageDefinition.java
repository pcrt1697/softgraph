package com.pcrt.softgraph.graphql.search;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class PageDefinition {

    @Min(0)
    private Integer page;
    @Min(1)
    private Integer size;

    public Pageable toPageable() {
        return PageRequest.of(page, size, Sort.by(Sort.Order.asc("id")));
    }

}
