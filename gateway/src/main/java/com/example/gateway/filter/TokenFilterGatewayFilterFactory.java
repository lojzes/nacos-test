package com.example.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 描述：非全局filter
 *
 * @author lyyitit@foxmail.com
 * @date 2019/8/19 13:36
 */
public class TokenFilterGatewayFilterFactory implements GatewayFilter,Ordered{

    private final static String token_ = "token";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        String token = request.getQueryParams().getFirst(token_);

        if(token != null && "token".equals(token)){
           return chain.filter(exchange);
        }else{
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
           return response.setComplete();
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
