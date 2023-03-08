package com.papa.yogiyogi.service;

import com.google.firebase.auth.FirebaseAuthException;
import com.papa.yogiyogi.domain.entity.AuctionBuy;
import com.papa.yogiyogi.domain.entity.AuctionComment;
import com.papa.yogiyogi.domain.request.InsertAuctionCommentRequest;
import com.papa.yogiyogi.domain.response.InsertAuctionCommentResponse;
import com.papa.yogiyogi.repository.AuctionCommentRepository;
import com.papa.yogiyogi.security.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service

public class AuctionCommentService {
    private final AuctionCommentRepository auctionCommentRepository;
    private final SecurityService securityService;
    private final FireBaseService fireBaseService;

    // 1. 등록
    public InsertAuctionCommentResponse insertAuctionComment (InsertAuctionCommentRequest request, Long id) throws IOException, FirebaseAuthException {
        Long myID = securityService.parseToken(securityService.getToken()).getId();
        request.setBidderId(myID);
        String myImgPath = fireBaseService.uploadFiles(request.getFile(),request.getNameFile());
        AuctionComment auctionComment = new AuctionComment(request , myImgPath);
        auctionCommentRepository.save(auctionComment);
        return new InsertAuctionCommentResponse(auctionComment);

    }


}
