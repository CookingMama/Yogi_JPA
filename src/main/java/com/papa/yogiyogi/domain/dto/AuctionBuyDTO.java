package com.papa.yogiyogi.domain.dto;

import com.papa.yogiyogi.domain.entity.AuctionComment;
import com.papa.yogiyogi.domain.entity.User;
import com.papa.yogiyogi.domain.request.InsertAuctionBuyRequest;
import com.papa.yogiyogi.security.TokenInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuctionBuyDTO {
    private Long id;
    private String title;
    private String content;
    private Long buyerId;
    private String buyerNickName;
    private ECategory category;
    private ECondition minCondition;
    private Integer lowWishPrice;
    private Integer highWishPrice;
    private Long inputTime;
    private LocalDateTime timeout;
    private Boolean isFinished = false;
    private Long sellerId = null;
    private String sellerNickName;

    public AuctionBuyDTO(TokenInfo token, InsertAuctionBuyRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();
        this.buyerId = token.getId();
        this.buyerNickName = token.getNickName();
        this.category = request.getCategory();
        this.minCondition = request.getMinCondition();
        this.lowWishPrice = request.getLowWishPrice();
        this.highWishPrice = request.getHighWishPrice();
        this.inputTime = request.getInputTime();;
    }

}
