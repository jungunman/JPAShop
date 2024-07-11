package com.woong.shop.dtos.request;

import com.woong.shop.entity.Item;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ItemRequestDto {
    private Long id;
    private String title;
    private Integer price;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) throws Exception {
        if(title.length() > 3 && title.length() < 1000){
            this.title = title;
        }else if(title.isEmpty()){
            throw new Exception("공백은 입력할 수 없습니다");
        }else{
            throw new Exception("글자 수 범위가 적거나 넘었습니다.");
        }
    }

    public void setPrice(Integer price) throws Exception {
        if (price < 2100000000 && price >0){
            this.price = price;
        }else{
            throw new Exception("숫자의 범위가 넘었습니다.");
        }
    }

}
