package com.woong.shop.dto.request;

import lombok.Getter;
import lombok.ToString;
import org.apache.coyote.BadRequestException;

@Getter
@ToString
public class ItemRequest {
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
            throw new BadRequestException("공백은 입력할 수 없습니다");
        }else{
            throw new BadRequestException("글자 수 범위가 적거나 넘었습니다.");
        }
    }

    public void setPrice(Integer price) throws Exception {
        if (price < 2100000000 && price >0){
            this.price = price;
        }else{
            throw new BadRequestException("숫자의 범위가 넘었습니다.");
        }
    }

}
