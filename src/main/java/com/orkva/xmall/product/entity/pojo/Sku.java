package com.orkva.xmall.product.entity.pojo;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.time.Instant;

/**
 * Sku
 *
 * @author Shepherd Xie
 * @version 2023/8/18
 */
@Entity
@Data
@Table(name = "tb_sku")
public class Sku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long spuId;
    private String title;
    private Long price;
    private Boolean saleable;
    private Boolean valid;

    @Generated
    private Instant createdDate;
    @Generated(event = {EventType.INSERT, EventType.UPDATE})
    private Instant updatedDate;
}
