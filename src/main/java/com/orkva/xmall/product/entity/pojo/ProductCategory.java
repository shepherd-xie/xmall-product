package com.orkva.xmall.product.entity.pojo;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.time.Instant;

/**
 * ProductCategory
 *
 * @author Shepherd Xie
 * @version 2023/8/18
 */
@Entity
@Data
@Table(name = "tb_category")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long parentId;
    private Boolean parent;
    private Integer sort;

    @Generated
    private Instant createdDate;
    @Generated(event = {EventType.INSERT, EventType.UPDATE})
    private Instant updatedDate;
}
