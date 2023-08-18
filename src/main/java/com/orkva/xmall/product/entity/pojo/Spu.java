package com.orkva.xmall.product.entity.pojo;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.time.Instant;

/**
 * Spu
 *
 * @author Shepherd Xie
 * @version 2023/8/18
 */
@Entity
@Data
@Table(name = "tb_spu")
public class Spu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String subTitle;
    private Long categoryId;
    private Boolean saleable;
    private Boolean valid;

    @Generated
    private Instant createdDate;
    @Generated(event = {EventType.INSERT, EventType.UPDATE})
    private Instant updatedDate;
}
