package com.example.nacos.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/8/14 0014 13:05
 */
@RestController
@RequestMapping("config")
@RefreshScope
public class ConfigTest {
    @Value("${env:default}")
    private String env;

    @GetMapping("get")
    public Object get(){
        return env;
    }
}
