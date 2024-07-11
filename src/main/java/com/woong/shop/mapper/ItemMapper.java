package com.woong.shop.mapper;

import com.woong.shop.dto.request.ItemRequest;
import com.woong.shop.dto.response.ItemResponse;
import com.woong.shop.entity.Item;

public class ItemMapper {

    /** Item Entity 기본 값*/
    public static ItemResponse toItemResponse(Item item){

        return new ItemResponse()
                .builder()
                .id(item.getId())
                .title(item.getTitle())
                .price(item.getPrice())
                .build();
    }

    /** Item Request DTO -> Item Entity
     *  Request는 조건에 해당하는 것들만 가지고 있음
     * */
    public static Item toEntity(ItemRequest itemRequest){
        Item item = new Item();
        item.setId(itemRequest.getId());
        item.setTitle(itemRequest.getTitle());
        item.setPrice(itemRequest.getPrice());

        return item;
    }
}
