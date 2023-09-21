package com.orkva.project.xmall.product.entity.pojo;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.time.Instant;

/**
 * SkuImage
 *
 * @author Shepherd Xie
 * @version 2023/8/18
 */
@Entity
@Data
@Table(name = "tb_sku_images")
public class SkuImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long skuId;
    private String imageUrl;
    private String title;
    private String desc;

    @Generated
    private Instant createdDate;
    @Generated(event = {EventType.INSERT, EventType.UPDATE})
    private Instant updatedDate;
}
