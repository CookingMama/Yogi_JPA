package com.papa.yogiyogi.domain.request;

import com.papa.yogiyogi.domain.dto.ECondition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

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
    private MultipartFile file;
    private String nameFile;

    public InsertAuctionCommentRequest(Long id ,String title, String content, ECondition pCondition, Integer biddingPrice, MultipartFile file, String nameFile) {
        this.auctionId = id;
        this.title = title;
        this.content = content;
        this.pCondition = pCondition;
        this.biddingPrice = biddingPrice;
        this.file = file;
        this.nameFile = nameFile;

    }

}
