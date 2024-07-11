package com.woong.shop.controller;

import com.woong.shop.dto.request.ItemRequest;
import com.woong.shop.dto.response.ItemResponse;
import com.woong.shop.entity.Item;
import com.woong.shop.repository.ItemRepository;
import com.woong.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController{

    private final ItemService itemService;

    /* Item의 List를 출력 */
    @GetMapping("/items")
    public String getItemList(Model m){
        List<ItemResponse> lst = itemService.showItemList();
        m.addAttribute("items",lst);

        return "list.html";
    }

    /* 아이템 등록 Form */
    @GetMapping("/item")
    public String viewItemForm(){
        return "write.html";
    }

    /* 새로운 Item 등록 */
    @PostMapping("/item")
    public String addItem(ItemRequest itemRequest){
        itemService.addItem(itemRequest);
        return "redirect:/list";
    }

    /* Item의 상세 정보 출력 */
    @GetMapping("/items/{id}")
    public String viewItemDetail(Model model, @PathVariable Long id) throws BadRequestException {
        model.addAttribute("item",itemService.showDetail(id));

        return "detail.html";
    }

    /* Item 수정 Form  */
    @GetMapping("/item/{id}")
    public String viewItemUpdateForm(Model model, @PathVariable Long id) throws BadRequestException {
        model.addAttribute("item",itemService.showDetail(id));
        return "update.html";
    }

    /* Item의 상세 정보 수정*/
    @PostMapping("/item/{id}")
    public String updateItem(Model model, ItemRequest itemRequest){
        model.addAttribute("item",itemService.updateItem(itemRequest));
        return "detail.html";
    }


}
