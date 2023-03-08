package com.papa.yogiyogi.repository;

import com.papa.yogiyogi.domain.entity.AuctionComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionCommentRepository extends JpaRepository<AuctionComment,Long> {
}
