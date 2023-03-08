package com.papa.yogiyogi.domain.response;

import com.papa.yogiyogi.domain.dto.ECategory;
import com.papa.yogiyogi.domain.entity.ProductSell;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InsertProductSellResponse {
    private String title;
    private String url;
    private Long sellerId;
    private ECategory category;
    private Integer price;

    public InsertProductSellResponse(ProductSell productSell) {
        this.title = productSell.getTitle();
        this.url = productSell.getUrl();
        this.sellerId = productSell.getSellerId().getId();
        this.category = productSell.getCategory();
        this.price = productSell.getPrice();
    }


}
