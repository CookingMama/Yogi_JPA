package com.papa.yogiyogi.controller;

import com.google.firebase.auth.FirebaseAuthException;
import com.papa.yogiyogi.domain.dto.ECategory;
import com.papa.yogiyogi.domain.dto.ECondition;
import com.papa.yogiyogi.domain.request.InsertAuctionBuyRequest;
import com.papa.yogiyogi.domain.request.InsertAuctionCommentRequest;
import com.papa.yogiyogi.domain.response.*;
import com.papa.yogiyogi.service.AuctionBuyService;
import com.papa.yogiyogi.service.AuctionCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/auction")
@RequiredArgsConstructor
public class AuctionBuyController {
    private final AuctionBuyService auctionBuyService;
    private final AuctionCommentService auctionCommentService;

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

    @PostMapping("/{id}/comment")
    public InsertAuctionCommentResponse insertAuctionComment (
            @PathVariable Long id,
            String title,
            String content,
            ECondition pCondition,
            Integer biddingPrice,
            @RequestParam("file") MultipartFile file,
            String nameFile
            ) throws IOException, FirebaseAuthException {
        InsertAuctionCommentRequest request = new InsertAuctionCommentRequest(
                id,
                title,
                content,
                pCondition,
                biddingPrice,
                file,
                nameFile
        );
        return auctionCommentService.insertAuctionComment(request, id);
    }
}
