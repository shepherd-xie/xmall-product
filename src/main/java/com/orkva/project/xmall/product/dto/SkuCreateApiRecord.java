package com.orkva.project.xmall.product.dto;

/**
 * SkuCreateApiRecord
 *
 * @author Shepherd Xie
 * @version 2023/9/21
 */
public record SkuCreateApiRecord(
        Long spuId,
        String title,
        Long price,
        Boolean saleable,
        Boolean valid
) {
}
