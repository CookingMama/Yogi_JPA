package com.papa.yogiyogi.controller;

import com.papa.yogiyogi.domain.request.InsertAuctionBuyRequest;
import com.papa.yogiyogi.domain.response.InsertAuctionBuyResponse;
import com.papa.yogiyogi.domain.response.ViewAuctionBuyListResponse;
import com.papa.yogiyogi.domain.response.ViewDetailAuctionBuyResponse;
import com.papa.yogiyogi.domain.response.ViewProductSellListResponse;
import com.papa.yogiyogi.service.AuctionBuyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auction")
@RequiredArgsConstructor
public class AuctionBuyController {
    private final AuctionBuyService auctionBuyService;

    @PostMapping("/post")
    public InsertAuctionBuyResponse insertAuctionBuy (@RequestBody InsertAuctionBuyRequest request) {
        return auctionBuyService.insertAuctionBuy(request);
    }

    @GetMapping
    public List<ViewAuctionBuyListResponse> findAllAuctionBuy(Pageable pageable) {
        return auctionBuyService.findAllAuctionBuy(pageable);
    }

    @GetMapping("/{id}")
    public ViewDetailAuctionBuyResponse findDetailAuctionBuy (@PathVariable Long id) {
        return auctionBuyService.findDetailAuctionBuy(id);
    }
}
