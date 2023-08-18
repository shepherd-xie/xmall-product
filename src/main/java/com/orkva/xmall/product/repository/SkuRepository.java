package com.orkva.xmall.product.repository;

import com.orkva.xmall.common.repository.BaseRepository;
import com.orkva.xmall.product.entity.pojo.Sku;

import java.util.List;

/**
 * SkuRepository
 *
 * @author Shepherd Xie
 * @version 2023/8/18
 */
public interface SkuRepository extends BaseRepository<Sku> {
    List<Sku> findBySpuId(Long spuId);
}
