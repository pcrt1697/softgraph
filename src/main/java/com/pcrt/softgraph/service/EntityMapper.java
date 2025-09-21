package com.pcrt.softgraph.service;

public interface EntityMapper<N, E> {
    E toEntity(N node);
}
