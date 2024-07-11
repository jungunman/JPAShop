package com.woong.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZonedDateTime;
import java.util.Date;

@Controller
public class BasicController {

    @GetMapping("/")
    public String getIndexPage(){
        return "index.html";
    }

    @GetMapping("/date")
    @ResponseBody
    public String getDate(){
        return ZonedDateTime.now().toString();
    }

}
