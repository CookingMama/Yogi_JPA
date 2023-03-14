package com.papa.yogiyogi.domain.response;

import com.papa.yogiyogi.domain.dto.EAuctionStatus;
import com.papa.yogiyogi.domain.dto.ECategory;
import com.papa.yogiyogi.domain.dto.ECondition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ViewAuctionBuyListResponse {
    private Long id;
    private String title;
    private String buyerNickName;
    private ECategory category;
    private ECondition minCondition;
    private Integer highWishPrice;
    private LocalDateTime timeout;
    private EAuctionStatus auctionStatus;
    private Integer commentCount;
}
