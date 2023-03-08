package com.papa.yogiyogi.domain.entity;

import com.papa.yogiyogi.domain.dto.ECategory;
import com.papa.yogiyogi.domain.dto.ECondition;
import com.papa.yogiyogi.domain.request.InsertAuctionBuyRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AuctionBuy {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    private User buyerId;
    @Enumerated(EnumType.STRING)
    private ECategory category;
    private ECondition minCondition;
    private Integer lowWishPrice;
    private Integer highWishPrice;
    private LocalDateTime timeout;
    private Boolean isFinished = false;
    private Long sellerId = null;

    @OneToMany(mappedBy = "auctionId", fetch = FetchType.LAZY)
    private List<AuctionComment> auctionComments = new ArrayList<>();

    public AuctionBuy(InsertAuctionBuyRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();
        this.buyerId = new User(request.getBuyerId());
        this.category = request.getCategory();
        this.minCondition = request.getMinCondition();
        this.lowWishPrice = request.getLowWishPrice();
        this.highWishPrice = request.getHighWishPrice();
        this.timeout = Instant.ofEpochMilli(request.getInputTime() + 32400000).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
