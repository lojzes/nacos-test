package com.example.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/8/15 0015 15:40
 */
@RestController
public class FailbackController {

    @GetMapping("fallback")
    public String failback(){

        return "fallback";
    }


}
