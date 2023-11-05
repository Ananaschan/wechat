package com.qin.wechat.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
// EncodingAESKey: oGsc5OHPzrmwmrYpVZ6JHb8DldD1VZvCMVPuT2PVn8J

@CrossOrigin
@RestController
public class WeChatApi {
    @GetMapping("/check")
    public String check(String signature,
                        String timestamp,
                        String nonce,
                        String echostr) throws NoSuchAlgorithmException {
        System.out.println("check");
        String token = "ananas";
        List<String> list = Arrays.asList(token, timestamp, nonce);
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        MessageDigest instance = MessageDigest.getInstance("sha1");
        byte[] digest = instance.digest(sb.toString().getBytes());
        StringBuilder sum = new StringBuilder();
        for (byte b : digest) {
            sum.append(Integer.toHexString(b>>4&15));
            sum.append(Integer.toHexString(b&15));
        }
        if (!StringUtils.isEmpty(signature) && signature.equals(sum.toString())){
            return echostr;
        }
        return null;

    }

}
