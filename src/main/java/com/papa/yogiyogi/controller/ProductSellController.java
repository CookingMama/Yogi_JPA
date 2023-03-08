package com.papa.yogiyogi.controller;

import com.papa.yogiyogi.domain.entity.ProductSell;
import com.papa.yogiyogi.domain.request.InsertProductSellRequest;
import com.papa.yogiyogi.domain.response.InsertProductSellResponse;
import com.papa.yogiyogi.domain.response.ViewProductSellListResponse;
import com.papa.yogiyogi.service.ProductSellService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/productsell")
@RequiredArgsConstructor
public class ProductSellController {
    private final ProductSellService productSellService;
    @PostMapping("/post")
    public InsertProductSellResponse insertProductSell(@RequestBody InsertProductSellRequest request) {
        return productSellService.insertProductSell(request);
    }
    @GetMapping
    public List<ViewProductSellListResponse> findAllProductSell(Pageable pageable) {

        return productSellService.findAllProductSell(pageable);
    }

}
