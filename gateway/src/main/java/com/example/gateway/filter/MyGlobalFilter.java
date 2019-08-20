package com.example.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 *  全局过滤器无需配置，加入spring容器即可
 *
 * @author lyyitit@foxmail.com
 * @date 2019/8/19 19:42
 */
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        System.out.println("_________________MyGlobalFilter______________________");

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
