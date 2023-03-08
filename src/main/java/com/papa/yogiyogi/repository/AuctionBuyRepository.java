package com.papa.yogiyogi.repository;

import com.papa.yogiyogi.domain.entity.AuctionBuy;
import com.papa.yogiyogi.domain.entity.ProductSell;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionBuyRepository extends JpaRepository<AuctionBuy, Long> {
    Page<AuctionBuy> findAllByOrderByIdDesc(Pageable pageable);
}
