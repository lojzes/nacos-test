package com.example.nacosconfig.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
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
public class ConfigTest {

    @NacosValue(value = "${flag:false}",autoRefreshed = true)
    private boolean flag = false;

    @GetMapping("get")
    public Object get(){
        return flag;
    }
}
