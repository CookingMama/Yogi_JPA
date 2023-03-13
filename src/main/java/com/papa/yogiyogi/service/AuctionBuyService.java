package com.papa.yogiyogi.service;

import com.papa.yogiyogi.Exception.WrongCommentIdError;
import com.papa.yogiyogi.domain.dto.AuctionBuyDTO;
import com.papa.yogiyogi.domain.entity.AuctionBuy;
import com.papa.yogiyogi.domain.entity.AuctionComment;
import com.papa.yogiyogi.domain.entity.ProductSell;
import com.papa.yogiyogi.domain.response.InsertAuctionBuyResponse;
import com.papa.yogiyogi.domain.response.ViewAuctionBuyListResponse;
import com.papa.yogiyogi.domain.response.ViewDetailAuctionBuyResponse;
import com.papa.yogiyogi.domain.response.ViewProductSellListResponse;
import com.papa.yogiyogi.repository.AuctionBuyRepository;
import com.papa.yogiyogi.repository.AuctionCommentRepository;
import com.papa.yogiyogi.security.SecurityService;
import com.papa.yogiyogi.security.TokenInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuctionBuyService {
    private final AuctionBuyRepository auctionBuyRepository;
    private final SecurityService securityService;

    private final AuctionCommentRepository auctionCommentRepository;

    // 1. 등록
    public InsertAuctionBuyResponse insertAuctionBuy (AuctionBuyDTO dto) {

        AuctionBuy auctionBuy = new AuctionBuy(dto);
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
        return new ViewDetailAuctionBuyResponse(byId.get());
    }
    // 4. 경매가 판매완료시 update 로 수정
    public  String updateBuy (Long id, Long commentId) throws WrongCommentIdError{
        Optional<AuctionComment>auctionComment = auctionCommentRepository.findById(commentId);
        if (!Objects.equals(id, auctionComment.get().getAuctionId().getId())) {
            throw new WrongCommentIdError();
        }
        auctionBuyRepository.updateAuctionBuyStatus(true, auctionComment.get().getId(), id);
        return "변경 완료";

    }
    // 5. 나의 경매목록 보기
    public List<ViewAuctionBuyListResponse> viewMyAuctionBuy() {
        List<ViewAuctionBuyListResponse> viewMyAuctionBuyListResponses = new ArrayList<>();
        TokenInfo token = securityService.parseToken(securityService.getToken());
        Long myId = token.getId();
        List<AuctionBuy> all = auctionBuyRepository.findAllByBuyerId(myId);
        for (AuctionBuy one: all) {
            viewMyAuctionBuyListResponses.add(new ViewAuctionBuyListResponse(
                    one.getId(),
                    one.getTitle(),
                    one.getBuyerId().getNickName(),
                    one.getCategory(),
                    one.getMinCondition(),
                    one.getHighWishPrice(),
                    one.getTimeout()
            ));
        }
        return viewMyAuctionBuyListResponses;
    }

}
