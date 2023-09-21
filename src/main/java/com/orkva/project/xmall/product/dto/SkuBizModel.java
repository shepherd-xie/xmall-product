package com.orkva.project.xmall.product.dto;

import lombok.Data;

import java.time.Instant;

/**
 * SkuBizModel
 *
 * @author Shepherd Xie
 * @version 2023/9/21
 */
@Data
public class SkuBizModel {
    private Long id;
    private Long spuId;
    private String title;
    private Long price;
    private Boolean saleable;
    private Boolean valid;
    private Instant createdDate;
    private Instant updatedDate;
}
