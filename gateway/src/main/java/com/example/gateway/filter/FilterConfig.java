package com.example.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/8/19 19:31
 */
@Configuration
public class FilterConfig {

    /**
       局部filter配置文件中的filter 名称为：  * + GatewayFilterFactory
      详情参考：GatewayFilterFactory.name
     {@link GatewayFilterFactory.name}
     */
    @Component
    public class TokenGatewayFilterFactory extends AbstractGatewayFilterFactory<Object>
    {
        @Override
        public GatewayFilter apply(Object config)
        {
            return new TokenFilterGatewayFilterFactory();
        }
    }
}
