package com.pcrt.softgraph.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PageUtils {
    public static <T> Page<T> getPage(List<T> items, Pageable pageable) {
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), items.size());
        return new PageImpl<>(items.subList(start, end), pageable, items.size());
    }
}
