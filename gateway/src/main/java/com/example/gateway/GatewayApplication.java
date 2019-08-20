package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    /**
     * @Title: fallback
     * @Description: 一个简单的降级页面
     * @return
     */
   /* @RequestMapping("/fallback")
    public Mono<String> fallback() {
        // Mono是一个Reactive stream，对外输出一个“fallback”字符串。
        return Mono.just("fallback");
    }*/

    /*@Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // 配制一个路由,把 http://网关地址:网关端口/demo/ 下的请求路由到 demo-service 微服务中
                .route(p -> p
                        .path("/demo/**")
                        .filters(f -> f
                                // 对path()指定的请求使用熔断器
                                .hystrix(config -> config
                                        // 熔断器的名字
                                        .setName("mycmd")
                                        // 熔断到 /fallback, 就是上面配制的那个
                                        .setFallbackUri("forward:/fallback")))
                        // 将请求路由到指定目标, lb开头是注册中心中的服务, http/https 开头你懂的
                        .uri("lb://service-provider"))
                .build();
    }*/


}
