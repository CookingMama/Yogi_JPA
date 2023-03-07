package com.papa.yogiyogi.domain.entity;

import com.papa.yogiyogi.domain.dto.ECategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
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
    private Integer price;
    @ManyToOne(fetch = FetchType.LAZY)
    private User buyerId;
    private Boolean isSold;
}
