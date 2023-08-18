package com.orkva.xmall.product.entity.pojo;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.time.Instant;

/**
 * SkuParam
 *
 * @author Shepherd Xie
 * @version 2023/8/18
 */
@Entity
@Data
@Table(name = "tb_sku_params")
public class SkuParam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long skuId;
    private String name;
    private String value;

    @Generated
    private Instant createdDate;
    @Generated(event = {EventType.INSERT, EventType.UPDATE})
    private Instant updatedDate;
}
