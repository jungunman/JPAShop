package com.woong.shop.service.impl;

import com.woong.shop.dto.request.ItemRequest;
import com.woong.shop.dto.response.ItemResponse;
import com.woong.shop.entity.Item;
import com.woong.shop.mapper.ItemMapper;
import com.woong.shop.repository.ItemRepository;
import com.woong.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.hibernate.PropertyNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    /** 페이징 하면서 수정 필요 */
    @Override
    public List<ItemResponse> showItemList() {

        //List<Item> 을 List<ItemResponse>로 변환하여 리턴
        return itemRepository.findAll()
                .stream()
                .map(item -> new ItemResponse().builder()
                        .id(item.getId())
                        .title(item.getTitle())
                        .price(item.getPrice())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public ItemResponse showDetail(Long id) throws BadRequestException {
        Optional<Item> item = itemRepository.findById(id);

        // 값이 Null 이라면 Long id 값이 잘못되었으므로 BadRequsetException 발생
        if (!item.isPresent()){
           throw new BadRequestException("해당 상품을 찾을 수 없습니다.");
        }

        return ItemMapper.toItemResponse(item.get());
    }

    @Override
    public void addItem(ItemRequest itemRequest) {
        itemRepository.save(ItemMapper.toEntity(itemRequest));
    }

    @Override
    public void deleteItem(ItemRequest itemRequest) {
        //미구현
    }

    @Override
    public ItemResponse updateItem(ItemRequest itemRequest) {
       Optional<Item> item = itemRepository.findById(itemRequest.getId());

       if(item.isPresent()){
           Item updateItem = item.get();
           updateItem.setTitle(itemRequest.getTitle());
           updateItem.setPrice(itemRequest.getPrice());

           //ItemResponse로 변환하여 리턴
           return ItemMapper.toItemResponse(itemRepository.save(updateItem));
       }else{
           throw new PropertyNotFoundException("해당 게시글은 존재하지 않아 수정할 수 없는 게시글입니다.");
       }
    }
}
