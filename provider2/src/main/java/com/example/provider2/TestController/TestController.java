package com.example.provider2.TestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/8/15 0015 15:52
 */
@RestController
public class TestController {

    @GetMapping("echo/{name}")
    public String get2(@PathVariable String name){

        return "hello2 "+ name;
    }
}
