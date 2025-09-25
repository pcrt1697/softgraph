package com.pcrt.softgraph.service;

import java.util.List;

public interface EntityMapper<N, E> {
    E toEntity(N node);
    List<E> toEntities(List<N> nodes);
}
