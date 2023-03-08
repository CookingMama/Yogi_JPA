package com.papa.yogiyogi.domain.request;

import com.papa.yogiyogi.domain.dto.ECategory;
import com.papa.yogiyogi.domain.dto.ECondition;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
public class InsertProductSellRequest {
    private String title;
    private String content;
    private Long sellerId;
    private ECategory category;
    private ECondition pCondition;
    private Integer price;
    private MultipartFile file;
    private String nameFile;

    public InsertProductSellRequest(
            String title,
            String content,
            ECategory category,
            ECondition pCondition,
            Integer price,
            MultipartFile file,
            String nameFile) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.pCondition = pCondition;
        this.price = price;
        this.file = file;
        this.nameFile = nameFile;
    }
}
