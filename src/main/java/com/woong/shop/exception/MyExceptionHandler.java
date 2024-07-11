package com.woong.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//@ControllerAdvice
public class MyExceptionHandler {

    public ResponseEntity<String> occurException(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("전역 Error 코드");
    }

}
