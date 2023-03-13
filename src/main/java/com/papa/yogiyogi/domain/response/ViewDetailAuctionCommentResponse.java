package com.papa.yogiyogi.domain.response;

import com.papa.yogiyogi.domain.dto.ECondition;
import com.papa.yogiyogi.domain.entity.AuctionComment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ViewDetailAuctionCommentResponse {

    private Long auctionId;
    private String bidderNickName;
    private String title;
    private String content;
    private ECondition pCondition;
    private Integer biddingPrice;
    private MultipartFile file;
    private String nameFile;

    public ViewDetailAuctionCommentResponse(AuctionComment auctionComment) {
    }
}
