package com.woong.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/list")
@RequiredArgsConstructor
public class ItemController{

    private final ItemRepository itemRepository;

    @GetMapping("")
    public String getList(Model m){
        List<Item> lst = itemRepository.findAll();
        m.addAttribute("items",lst);
        return "list.html";
    }


}
