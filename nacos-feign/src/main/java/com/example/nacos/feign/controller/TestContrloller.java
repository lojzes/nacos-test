package com.example.nacos.feign.controller;

import com.example.nacos.feign.feignClient.EchoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/8/14 0014 15:34
 */
@RestController
public class TestContrloller {
    @Autowired
    private EchoClient echoClient;

    @GetMapping("feign/{name}")
    public String test(@PathVariable String name){
        return echoClient.echo(name);

    }
}
