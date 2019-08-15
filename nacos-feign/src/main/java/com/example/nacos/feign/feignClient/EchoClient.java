package com.example.nacos.feign.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/8/14 0014 15:36
 */
@FeignClient("service-provider")
public interface EchoClient {

    @RequestMapping(value = "echo/{name}",method = RequestMethod.GET)
    String echo(@PathVariable("name") String name);
}
