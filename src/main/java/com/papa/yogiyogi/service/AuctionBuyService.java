package com.papa.yogiyogi.service;

import com.papa.yogiyogi.domain.dto.ECategory;
import com.papa.yogiyogi.domain.entity.AuctionBuy;
import com.papa.yogiyogi.domain.entity.ProductSell;
import com.papa.yogiyogi.domain.request.InsertAuctionBuyRequest;
import com.papa.yogiyogi.domain.response.InsertAuctionBuyResponse;
import com.papa.yogiyogi.domain.response.ViewAuctionBuyListResponse;
import com.papa.yogiyogi.domain.response.ViewDetailAuctionBuyResponse;
import com.papa.yogiyogi.repository.AuctionBuyRepository;
import com.papa.yogiyogi.security.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuctionBuyService {
    private final AuctionBuyRepository auctionBuyRepository;
    private final SecurityService securityService;

    // 1. 등록
    public InsertAuctionBuyResponse insertAuctionBuy (InsertAuctionBuyRequest request) {
        Long myID = securityService.parseToken(securityService.getToken()).getId();
        request.setBuyerId(myID);
        AuctionBuy auctionBuy = new AuctionBuy(request);
        System.out.println(request);
        auctionBuyRepository.save(auctionBuy);
        return new InsertAuctionBuyResponse(auctionBuy);


    }
    // 2.모든 등록된 경매 리스트 보기
    public List<ViewAuctionBuyListResponse> findAllAuctionBuy(Pageable pageable) {
        List<ViewAuctionBuyListResponse> viewAuctionBuyListResponses = new ArrayList<>();
        Page<AuctionBuy> all = auctionBuyRepository.findAllByOrderByIdDesc(pageable);
        for (AuctionBuy one: all) {
            viewAuctionBuyListResponses.add(new ViewAuctionBuyListResponse(
                    one.getId(),
                    one.getTitle(),
                    one.getBuyerId().getNickName(),
                    one.getCategory(),
                    one.getMinCondition(),
                    one.getHighWishPrice(),
                    one.getTimeout()
            ));
        }
        return viewAuctionBuyListResponses;
    }
    // 3.하나의 경매의 세부정보 확인
    public ViewDetailAuctionBuyResponse findDetailAuctionBuy(Long id) {
        Optional<AuctionBuy> byId = auctionBuyRepository.findById(id);
        ViewDetailAuctionBuyResponse viewDetailAuctionBuyResponse = new ViewDetailAuctionBuyResponse(byId.get());
        viewDetailAuctionBuyResponse.setBuyerNickName(securityService.parseToken(securityService.getToken()).getNickName());
        return viewDetailAuctionBuyResponse;
    }
    // 4. 경매가 판매완료시 update 로 수정

}
