package com.example.nacos.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/8/14 0014 14:56
 */
@RestController
public class EchoController {

    @GetMapping("echo/{name}")
    public String echo(@PathVariable String name){
        return "hello " + name;
    }

    @GetMapping("echo2")
    public String echo2(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("test")
    public String test(@RequestParam("name") String name){
        return "hello " + name;
    }
}
