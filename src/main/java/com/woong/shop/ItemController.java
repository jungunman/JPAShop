package com.woong.shop;

import com.woong.shop.dtos.requests.ItemRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController{

    private final ItemRepository itemRepository;

    @GetMapping("/list")
    public String getList(Model m){
        List<Item> lst = itemRepository.findAll();
        m.addAttribute("items",lst);
        return "list.html";
    }

    @GetMapping("/item")
    public String showItemForm(){
        return "write.html";
    }

    @PostMapping("/item")
    public String addItem(ItemRequestDto item){
        itemRepository.save(item.toItem());
        System.out.println("상품 등록 완료");

        return "redirect:/list";
    }

    @GetMapping("/items/{id}")
    public String getItemDetail(Model model, @PathVariable Long id){

        Optional<Item> item = itemRepository.findById(id);
        if ( item.isPresent()){
            model.addAttribute("item",item.get());
            return "detail.html";
        }

        return "redirect:/list";
    }

}
