package com.woong.shop.service;

import com.woong.shop.dto.response.ItemResponse;
import com.woong.shop.entity.Item;
import com.woong.shop.dto.request.ItemRequest;
import org.apache.coyote.BadRequestException;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    public List<ItemResponse> showItemList();
    public ItemResponse showDetail(Long id) throws BadRequestException;
    public void addItem(ItemRequest itemRequest);
    public void deleteItem(Long id);
    public ItemResponse updateItem(ItemRequest itemRequest) throws BadRequestException;
}
