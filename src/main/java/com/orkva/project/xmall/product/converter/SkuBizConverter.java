package com.orkva.project.xmall.product.converter;

import com.orkva.project.xmall.product.dto.SkuBizModel;
import com.orkva.project.xmall.product.entity.pojo.Sku;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SkuBizConverter
 *
 * @author Shepherd Xie
 * @version 2023/9/21
 */
public class SkuBizConverter {
    public static SkuBizModel toSkuBizModel(@NotNull Sku sku) {
        SkuBizModel skuBizModel = new SkuBizModel();
        skuBizModel.setId(sku.getId());
        skuBizModel.setSpuId(sku.getSpuId());
        skuBizModel.setTitle(sku.getTitle());
        skuBizModel.setPrice(sku.getPrice());
        skuBizModel.setSaleable(sku.getSaleable());
        skuBizModel.setValid(sku.getValid());
        skuBizModel.setCreatedDate(sku.getCreatedDate());
        skuBizModel.setUpdatedDate(sku.getUpdatedDate());
        return skuBizModel;
    }

    public static List<SkuBizModel> toSkuBizModels(@NotNull Collection<Sku> skus) {
        return skus.stream().map(SkuBizConverter::toSkuBizModel).collect(Collectors.toList());
    }

    public static Sku toSku(@NotNull SkuBizModel skuBizModel) {
        Sku sku = new Sku();
        sku.setSpuId(skuBizModel.getSpuId());
        sku.setTitle(skuBizModel.getTitle());
        sku.setPrice(skuBizModel.getPrice());
        sku.setSaleable(skuBizModel.getSaleable());
        sku.setValid(skuBizModel.getValid());
        sku.setCreatedDate(skuBizModel.getCreatedDate());
        sku.setUpdatedDate(skuBizModel.getUpdatedDate());
        return sku;
    }

    public static List<Sku> toSkus(@NotNull Collection<SkuBizModel> skuBizModels) {
        return skuBizModels.stream().map(SkuBizConverter::toSku).collect(Collectors.toList());
    }

    public static Page<SkuBizModel> toSkuBizModelPage(@NotNull Page<Sku> skuPage, @NotNull Pageable pageable) {
        return skuPage.stream()
                .map(SkuBizConverter::toSkuBizModel)
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> new PageImpl<>(list, pageable, skuPage.getTotalElements())));
    }
}
