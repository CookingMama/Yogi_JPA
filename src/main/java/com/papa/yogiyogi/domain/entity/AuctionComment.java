package com.papa.yogiyogi.domain.entity;

import com.papa.yogiyogi.domain.dto.ECondition;
import com.papa.yogiyogi.domain.request.InsertAuctionCommentRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AuctionComment {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auction_id")
    private AuctionBuy auctionId;
    private String title;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bidder_id")
    private User bidderId;
    private Integer biddingPrice;
    @Enumerated(EnumType.STRING)
    private ECondition pCondition;
    private String imgPath; //picture
    private String content;


    public AuctionComment(InsertAuctionCommentRequest request, String myImgPath) {
        this.id = request.getId();
        this.auctionId = new AuctionBuy(request.getAuctionId());
        this.title = request.getTitle();
        this.content = request.getContent();
        this.bidderId = new User(request.getBidderId());
        this.biddingPrice = request.getBiddingPrice();
        this.pCondition = request.getPCondition();
        this.imgPath = myImgPath;

    }
}
