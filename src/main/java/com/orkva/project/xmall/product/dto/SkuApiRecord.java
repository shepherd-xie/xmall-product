package com.orkva.project.xmall.product.dto;

import java.time.Instant;

/**
 * SkuApiRecord
 *
 * @author Shepherd Xie
 * @version 2023/9/21
 */
public record SkuApiRecord(
        Long id,
        Long spuId,
        String title,
        Long price,
        Boolean saleable,
        Boolean valid,
        Instant createdDate,
        Instant updatedDate
) {
}
