package com.papa.yogiyogi.repository;

import com.papa.yogiyogi.domain.entity.AuctionBuy;
import com.papa.yogiyogi.domain.entity.AuctionComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuctionCommentRepository extends JpaRepository<AuctionComment,Long> {
    Page<AuctionComment> findAllByOrderByBiddingPriceAsc(Pageable pageable);
    Page<AuctionComment> findAllByOrderByIdDesc(Pageable pageable);

    Page<AuctionComment> findAllByAuctionIdOrderByBiddingPriceAsc(Pageable pageable, Long auctionId);
}
