package com.papa.yogiyogi.repository;

import com.papa.yogiyogi.domain.dto.AuctionBuyDTO;
import com.papa.yogiyogi.domain.dto.EAuctionStatus;
import com.papa.yogiyogi.domain.entity.AuctionBuy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface AuctionBuyRepository extends JpaRepository<AuctionBuy, Long> {
    Page<AuctionBuyDTO> findAllByOrderByIdDesc(Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE AuctionBuy ab SET ab.auctionStatus = :auctionStatus, ab.sellerId = :sellerId WHERE ab.id = :id")
    int updateAuctionBuyStatus(EAuctionStatus auctionStatus, Long sellerId, Long id);

    @Query("select ab from AuctionBuy As ab " +
            "inner join ab.buyerId as u on u.id = :id")
    List<AuctionBuyDTO> findAllByBuyerId(@Param("id") Long buyerId);

    @Query("select ab from AuctionBuy As ab where ab.auctionStatus = 'proceeding'")
    List<AuctionBuy> findAllByAuctionStatus();


}
