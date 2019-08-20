package com.example.gateway.config;

import com.example.gateway.filter.TokenFilterGatewayFilterFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/8/19 13:51
 */
@Configuration
public class RouterConfig {

   //@Bean
   public RouteLocator routeLocator(RouteLocatorBuilder builder){
       return builder.routes()
               // 配制一个路由,把 http://网关地址:网关端口/demo/ 下的请求路由到 demo-service 微服务中
               .route(p -> p
                       .path("/demo/**")
                       .filters(f->f.filter(new TokenFilterGatewayFilterFactory()))
                       .uri("lb://service-provider"))
               .build();
   }


}
