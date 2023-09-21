package com.orkva.project.xmall.product.controller;

import com.orkva.project.xmall.product.converter.SkuApiConverter;
import com.orkva.project.xmall.product.dto.SkuApiQueryRecord;
import com.orkva.project.xmall.product.dto.SkuApiRecord;
import com.orkva.project.xmall.product.dto.SkuBizModel;
import com.orkva.project.xmall.product.dto.SkuCreateApiRecord;
import com.orkva.project.xmall.product.entity.pojo.Sku;
import com.orkva.project.xmall.product.service.SkuService;
import com.orkva.xmall.common.entity.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SkuController
 *
 * @author Shepherd Xie
 * @version 2023/9/21
 */
@Slf4j
@RestController
@RequestMapping("/api/skus")
public class SkuController {

    @Autowired
    private SkuService skuService;

    /**
     * 获取SKU列表
     *
     * @param skuApiQueryRecord 查询参数
     * @return 包含SKU信息的JSON结果
     */
    @GetMapping
    public JsonResult<List<SkuApiRecord>> listSku(SkuApiQueryRecord skuApiQueryRecord) {
        List<SkuBizModel> skuBizModels = skuService.list(SkuApiConverter.toSkuBizModel(skuApiQueryRecord));
        return JsonResult.ok(SkuApiConverter.toSkuApiRecords(skuBizModels));
    }

    /**
     * 创建新的SKU
     *
     * @param skuCreateApiRecord SKU创建参数
     * @return 包含新创建的SKU信息的JSON结果
     */
    @PostMapping
    public JsonResult<SkuApiRecord> createSku(@RequestBody SkuCreateApiRecord skuCreateApiRecord) {
        SkuBizModel sku = skuService.create(SkuApiConverter.toSkuBizModel(skuCreateApiRecord));
        return JsonResult.ok(SkuApiConverter.toSkuApiRecord(sku));
    }

    /**
     * 分页获取SKU列表
     *
     * @param skuApiQueryRecord 查询参数
     * @param pageable 分页参数
     * @return 包含分页结果的JSON结果
     */
    @GetMapping("/page")
    public JsonResult<Page<SkuApiRecord>> pageSku(SkuApiQueryRecord skuApiQueryRecord, @PageableDefault Pageable pageable) {
        Page<SkuBizModel> skus = skuService.page(SkuApiConverter.toSkuBizModel(skuApiQueryRecord), pageable);
        return JsonResult.ok(SkuApiConverter.toSkuApiRecordPage(skus, pageable));
    }

    /**
     * 根据ID列表获取SKU列表
     *
     * @param ids SKU ID列表
     * @return 包含SKU信息的JSON结果
     */
    @GetMapping("/batch")
    public JsonResult<List<Sku>> getSkusByIds(@RequestParam List<Long> ids) {
        List<Sku> skus = skuService.getSkusByIds(ids);
        return JsonResult.ok(skus);
    }
}
