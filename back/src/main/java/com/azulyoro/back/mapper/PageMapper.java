package com.azulyoro.back.mapper;

import com.azulyoro.back.dto.CustomPage;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PageMapper {
    public <T> CustomPage<T> pageToCustomPage(Page<T> page) {
        return CustomPage.<T>builder()
                .content(page.getContent())
                .pageNumber(page.getPageable().getPageNumber())
                .pageSize(page.getPageable().getPageSize())
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .first(page.isFirst())
                .last(page.isLast())
                .numberOfElements(page.getNumberOfElements())
                .build();
    }
}
