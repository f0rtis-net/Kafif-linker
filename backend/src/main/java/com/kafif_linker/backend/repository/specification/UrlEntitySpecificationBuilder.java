package com.kafif_linker.backend.repository.specification;

import com.kafif_linker.backend.model.dto.request.DeleteUrlEntityDto;
import com.kafif_linker.backend.model.entity.UrlEntity;
import org.springframework.data.jpa.domain.Specification;

public class UrlEntitySpecificationBuilder {
    public static Specification<UrlEntity> build(DeleteUrlEntityDto dto) {
        return (root, query, builder) -> builder.lessThanOrEqualTo(root.get("expires_in"), dto.getExpires_in());
    }
}
