package com.pcrt.softgraph.model.page;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Example;

@Getter
@Setter
public abstract class PageQuery <T> {
    public abstract Example<T> toExample();

}
