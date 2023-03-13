package com.papa.yogiyogi.repository;

import com.papa.yogiyogi.domain.entity.AuctionBuy;
import com.papa.yogiyogi.domain.entity.ProductSell;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface AuctionBuyRepository extends JpaRepository<AuctionBuy, Long> {
    Page<AuctionBuy> findAllByOrderByIdDesc(Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE AuctionBuy ab SET ab.isFinished = :isFinished, ab.sellerId = :sellerId WHERE ab.id = :id")
    int updateAuctionBuyStatus(Boolean isFinished, Long sellerId, Long id);

    @Query("select ac from AuctionBuy As ac " +
            "inner join ac.buyerId as u on u.id = :id")
    List<AuctionBuy> findAllByBuyerId(@Param("id") Long buyerId);

}
