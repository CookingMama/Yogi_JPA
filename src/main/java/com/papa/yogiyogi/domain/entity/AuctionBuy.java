package com.papa.yogiyogi.domain.entity;

import com.papa.yogiyogi.domain.dto.ECategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    private User buyerId;
    private ECategory category;
    private Integer lowWishPrice;
    private Integer highWishPrice;
    private LocalDateTime timeout;

    @OneToMany(mappedBy = "auctionId", fetch = FetchType.LAZY)
    private List<AuctionComment> auctionComments = new ArrayList<>();

}
