package com.orkva.project.xmall.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProductController
 *
 * @author Shepherd Xie
 * @version 2023/8/15
 */
@Slf4j
@RestController
public class ProductController {

    @GetMapping("/product/page")
    public void pageProduct() {

    }

    @GetMapping("/sku/page")
    public void pageSku() {

    }

    @GetMapping("/product/detail")
    public void getProductDetail() {

    }

    @GetMapping("/sku/detail")
    public void getSkuDetail() {

    }

}
