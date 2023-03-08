package com.papa.yogiyogi.controller;

import com.google.firebase.auth.FirebaseAuthException;
import com.papa.yogiyogi.domain.dto.ECategory;
import com.papa.yogiyogi.domain.dto.ECondition;
import com.papa.yogiyogi.domain.entity.ProductSell;
import com.papa.yogiyogi.domain.request.InsertProductSellRequest;
import com.papa.yogiyogi.domain.response.InsertProductSellResponse;
import com.papa.yogiyogi.domain.response.ViewProductSellListResponse;
import com.papa.yogiyogi.service.ProductSellService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/productsell")
@RequiredArgsConstructor
public class ProductSellController {
    private final ProductSellService productSellService;
    @PostMapping("/post")
    public InsertProductSellResponse insertProductSell( String title,
                                                        String content,
                                                        ECategory category,
                                                        ECondition pCondition,
                                                        Integer price,
                                                        @RequestParam("file") MultipartFile file,
                                                        String nameFile) throws IOException, FirebaseAuthException {
        InsertProductSellRequest request = new InsertProductSellRequest(
                title,
                content,
                category,
                pCondition,
                price,
                file,
                nameFile
        );

        return productSellService.insertProductSell(request);

    }
    @GetMapping
    public List<ViewProductSellListResponse> findAllProductSell(Pageable pageable) {

        return productSellService.findAllProductSell(pageable);
    }

}
