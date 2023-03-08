package com.papa.yogiyogi.domain.entity;

import com.papa.yogiyogi.domain.dto.ECategory;
import com.papa.yogiyogi.domain.dto.ECondition;
import com.papa.yogiyogi.domain.request.InsertProductSellRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductSell {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String title;
    private String url; //firebase picture
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private User sellerId;
    @Enumerated(EnumType.STRING)
    private ECategory category;
    private ECondition pCondition;
    private Integer price;
    @ManyToOne(fetch = FetchType.LAZY)
    private User buyerId;
    private Boolean isSold;


    public ProductSell(InsertProductSellRequest request , String myImgPath) {
        this.title = request.getTitle();
        this.url =myImgPath;
        this.sellerId = new User(request.getSellerId());
        this.category = request.getCategory();
        this.pCondition = request.getPCondition();
        this.price = request.getPrice();
    }
}
