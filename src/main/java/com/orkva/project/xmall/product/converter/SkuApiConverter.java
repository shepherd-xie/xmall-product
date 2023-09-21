package com.orkva.project.xmall.product.converter;

import com.orkva.project.xmall.product.dto.SkuApiQueryRecord;
import com.orkva.project.xmall.product.dto.SkuApiRecord;
import com.orkva.project.xmall.product.dto.SkuBizModel;
import com.orkva.project.xmall.product.dto.SkuCreateApiRecord;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SkuConverter
 *
 * @author Shepherd Xie
 * @version 2023/9/21
 */
public class SkuApiConverter {

    public static SkuBizModel toSkuBizModel(@NotNull SkuCreateApiRecord skuCreateApiRecord) {
        SkuBizModel skuBizModel = new SkuBizModel();
        skuBizModel.setSpuId(skuCreateApiRecord.spuId());
        skuBizModel.setTitle(skuCreateApiRecord.title());
        skuBizModel.setPrice(skuCreateApiRecord.price());
        skuBizModel.setSaleable(skuCreateApiRecord.saleable());
        skuBizModel.setValid(skuCreateApiRecord.valid());
        return skuBizModel;
    }

    public static SkuApiRecord toSkuApiRecord(@NotNull SkuBizModel skuBizModel) {
        return new SkuApiRecord(
                skuBizModel.getId(),
                skuBizModel.getSpuId(),
                skuBizModel.getTitle(),
                skuBizModel.getPrice(),
                skuBizModel.getSaleable(),
                skuBizModel.getValid(),
                skuBizModel.getCreatedDate(),
                skuBizModel.getUpdatedDate()
        );
    }

    public static Page<SkuApiRecord> toSkuApiRecordPage(@NotNull Page<SkuBizModel> skuPage, @NotNull Pageable pageable) {
        return skuPage.stream()
                .map(SkuApiConverter::toSkuApiRecord)
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> new PageImpl<>(list, pageable, skuPage.getTotalElements())));
    }

    public static List<SkuApiRecord> toSkuApiRecords(@NotNull Collection<SkuBizModel> skuBizModels) {
        return skuBizModels.stream()
                .map(SkuApiConverter::toSkuApiRecord)
                .collect(Collectors.toList());
    }

    public static SkuBizModel toSkuBizModel(@NotNull SkuApiQueryRecord skuApiQueryRecord) {
        SkuBizModel skuBizModel = new SkuBizModel();
        skuBizModel.setSpuId(skuApiQueryRecord.spuId());
        skuBizModel.setTitle(skuApiQueryRecord.title());
        skuBizModel.setPrice(skuApiQueryRecord.price());
        skuBizModel.setSaleable(skuApiQueryRecord.saleable());
        skuBizModel.setValid(skuApiQueryRecord.valid());
        return skuBizModel;
    }

    public static List<SkuBizModel> toSkuBizModels(@NotNull Collection<SkuApiQueryRecord> skuApiQueryRecords) {
        return skuApiQueryRecords.stream()
                .map(SkuApiConverter::toSkuBizModel)
                .collect(Collectors.toList());
    }

}
