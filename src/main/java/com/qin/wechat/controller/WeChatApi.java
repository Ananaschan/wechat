package com.qin.wechat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeChatApi {
    @GetMapping("/")
    public String check(){
        System.out.println("check");
        return "check";
    }

}
