package com.papa.yogiyogi.service;

import com.google.firebase.auth.FirebaseAuthException;
import com.papa.yogiyogi.domain.dto.AuctionCommentDTO;
import com.papa.yogiyogi.domain.dto.InsertProductSellDTO;
import com.papa.yogiyogi.domain.entity.AuctionBuy;
import com.papa.yogiyogi.domain.entity.AuctionComment;
import com.papa.yogiyogi.domain.entity.User;
import com.papa.yogiyogi.domain.request.InsertAuctionCommentRequest;
import com.papa.yogiyogi.domain.response.InsertAuctionCommentResponse;
import com.papa.yogiyogi.repository.AuctionCommentRepository;
import com.papa.yogiyogi.repository.UserRepository;
import com.papa.yogiyogi.security.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
@Service

public class AuctionCommentService {
    private final AuctionCommentRepository auctionCommentRepository;
    private final SecurityService securityService;
    private final FireBaseService fireBaseService;
    private final UserRepository userRepository;

    // 1. 등록
    public InsertAuctionCommentResponse insertAuctionComment (AuctionCommentDTO dto) throws IOException, FirebaseAuthException {
        String myImgPath = fireBaseService.uploadFiles(dto.getFile(),dto.getNameFile());
        Optional <User> findById = userRepository.findById(dto.getBidderId());
        User user = findById.orElseThrow(NullPointerException::new);

        AuctionComment auctionComment = new AuctionComment(dto , myImgPath, user);

        auctionCommentRepository.save(auctionComment);
        return new InsertAuctionCommentResponse(auctionComment);

    }


}
