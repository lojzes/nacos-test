

package com.packsofts.qn.gateway.config;

import com.example.gateway.handler.HystrixFallbackHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

/**
 * @author lengleng
 * @date 2018/7/5
 * 路由配置信息
 */
@Configuration
public class RouterFunctionConfiguration {
	private final HystrixFallbackHandler hystrixFallbackHandler;

    public RouterFunctionConfiguration(HystrixFallbackHandler hystrixFallbackHandler) {
        this.hystrixFallbackHandler = hystrixFallbackHandler;
    }

    @Bean
	public RouterFunction routerFunction() {
		return RouterFunctions.route(
			RequestPredicates.path("/fallback")
				.and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), hystrixFallbackHandler);
	}

}
