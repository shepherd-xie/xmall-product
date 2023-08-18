package com.orkva.xmall.product.service;

import com.orkva.xmall.product.entity.pojo.Sku;
import com.orkva.xmall.product.repository.SkuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * SkuService
 *
 * @author Shepherd Xie
 * @version 2023/8/18
 */
@Service
@Slf4j
@Transactional
public class SkuService {
    @Autowired
    private SkuRepository skuRepository;

    public List<Sku> listSkuById(Collection<Long> idSet) {
        return skuRepository.findAllById(idSet);
    }

    public Page<Sku> pageSku(Sku sku, Pageable pageable) {
        return skuRepository.findAll(Example.of(sku), pageable);
    }

    public List<Sku> getSkuBySpu(Long spuId) {
        return skuRepository.findBySpuId(spuId);
    }

}
