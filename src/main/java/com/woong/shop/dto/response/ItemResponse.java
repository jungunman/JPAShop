package com.woong.shop.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemResponse {
    private Long id;
    private String title;
    private Integer price;

    @Builder
    public ItemResponse(Long id, String title, Integer price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }
}
