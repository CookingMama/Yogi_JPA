package com.papa.yogiyogi.domain.request;

import com.papa.yogiyogi.domain.dto.ECategory;
import com.papa.yogiyogi.domain.dto.ECondition;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
public class InsertProductSellRequest {
    private String title;
    private String url;
    private Long sellerId;
    private ECategory category;
    private ECondition pCondition;
    private Integer price;
}
