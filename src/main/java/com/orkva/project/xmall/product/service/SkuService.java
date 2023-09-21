package com.orkva.project.xmall.product.service;

import com.orkva.project.xmall.product.converter.SkuBizConverter;
import com.orkva.project.xmall.product.dto.SkuBizModel;
import com.orkva.project.xmall.product.entity.pojo.Sku;
import com.orkva.project.xmall.product.repository.SkuRepository;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    // 新增
    public SkuBizModel create(SkuBizModel skuBizModel) {
        Sku sku = SkuBizConverter.toSku(skuBizModel);
        return SkuBizConverter.toSkuBizModel(skuRepository.saveAndFlush(sku));
    }

    // 删除
    public void deleteSkuById(long id) {
        skuRepository.deleteById(id);
    }

    // 根据ID查询
    public Sku getSkuById(long id) {
        return skuRepository.findById(id).orElseThrow();
    }

    public List<SkuBizModel> list(@NotNull SkuBizModel skuBizModel) {
        List<Sku> skus = skuRepository.findAll(Example.of(SkuBizConverter.toSku(skuBizModel)));
        return SkuBizConverter.toSkuBizModels(skus);
    }

    // 分页查询
    public Page<SkuBizModel> page(@NotNull SkuBizModel skuBizModel, @NotNull Pageable pageable) {
        Page<Sku> skuPage = skuRepository.findAll(Example.of(SkuBizConverter.toSku(skuBizModel)), pageable);
        return SkuBizConverter.toSkuBizModelPage(skuPage, pageable);
    }

    // 批量查询
    public List<Sku> getSkusByIds(List<Long> ids) {
        return skuRepository.findAllByIdIn(ids);
    }

}
