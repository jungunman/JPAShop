package com.woong.shop;

import lombok.Getter;

@Getter
public class MyInfo {

    private String name;
    private Integer age;


    public void plusAge(Integer age){
        this.age = age+1;
    }

    public void settingAge(Integer age){
        if (age <100 && age >0){
            this.age = age;
        }
    }


}
