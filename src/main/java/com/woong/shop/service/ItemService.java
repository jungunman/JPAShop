package com.woong.shop.service;

import com.woong.shop.entity.Item;
import com.woong.shop.dtos.request.ItemRequestDto;

import java.util.Optional;

public interface ItemService {
    public Optional<Item> showDetail(Long id);
    public void addItem(ItemRequestDto itemRequestDto);
    public void deleteItem(ItemRequestDto itemRequestDto);

}
