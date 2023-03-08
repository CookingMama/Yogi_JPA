package com.papa.yogiyogi.service;

import com.google.firebase.auth.FirebaseAuthException;
import com.papa.yogiyogi.domain.entity.ProductSell;
import com.papa.yogiyogi.domain.request.InsertProductSellRequest;
import com.papa.yogiyogi.domain.response.InsertProductSellResponse;
import com.papa.yogiyogi.domain.response.ViewProductSellListResponse;
import com.papa.yogiyogi.repository.ProductSellRepository;
import com.papa.yogiyogi.security.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductSellService {
    private final ProductSellRepository productSellRepository;
    private final SecurityService securityService;
    private final FireBaseService fireBaseService;

    public InsertProductSellResponse insertProductSell(InsertProductSellRequest request) throws IOException, FirebaseAuthException {
        Long myID = securityService.parseToken(securityService.getToken()).getId();
        request.setSellerId(myID);
        String myImgPath = fireBaseService.uploadFiles(request.getFile(),request.getNameFile());
        ProductSell productSell = new ProductSell(request, myImgPath);
        productSellRepository.save(productSell);
        return new InsertProductSellResponse(productSell);

    }

    public List<ViewProductSellListResponse> findAllProductSell(Pageable pageable) {
        List<ViewProductSellListResponse> viewProductSellListResponses = new ArrayList<>();
        Page<ProductSell> all = productSellRepository.findAllByOrderByIdDesc(pageable);
        for (ProductSell one:all) {
            viewProductSellListResponses.add(new ViewProductSellListResponse(
                    one.getId(), one.getTitle(),one.getUrl(),one.getSellerId().getNickName() ,one.getCategory(),one.getPrice()
            ));

        }
        return viewProductSellListResponses;
    }

}
