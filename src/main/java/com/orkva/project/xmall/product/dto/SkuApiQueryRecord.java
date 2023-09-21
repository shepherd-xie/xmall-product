package com.orkva.project.xmall.product.dto;

/**
 * SkuApiQueryRecord
 *
 * @author Shepherd Xie
 * @version 2023/9/21
 */
public record SkuApiQueryRecord(
        Long id,
        Long spuId,
        String title,
        Long price,
        Boolean saleable,
        Boolean valid
) {
}
