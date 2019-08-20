package com.example.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/8/20 9:13
 */
@Component
@Order(99)
public class IPForbidGatewayFilterFactory extends AbstractGatewayFilterFactory<IPForbidGatewayFilterFactory.Config> {
    public static final String IP = "ip";

    public IPForbidGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(IP);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String hostAddress = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
            System.out.println("hostAddress : " + hostAddress);
            System.out.println("config.getIp() : " + config.getIp());
            if(hostAddress.equals(config.getIp())){
               return chain.filter(exchange);
            }
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.FORBIDDEN);
            return  response.setComplete();
        };
    }

    public static class Config{
        private String ip;

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }
   }

}
