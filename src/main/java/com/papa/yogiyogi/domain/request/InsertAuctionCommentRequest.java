package com.papa.yogiyogi.domain.request;

import com.papa.yogiyogi.domain.dto.ECondition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InsertAuctionCommentRequest {
    private Long id;
    private Long auctionId;
    private String title;
    private String content;
    private Long bidderId;
    private ECondition pCondition;
    private Integer biddingPrice;
    private String imgPath;

}
