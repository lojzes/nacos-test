package com.example.gateway.dyroute;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executor;

@Component
@RefreshScope
public class DynamicRouteServiceImplByNacos{

    @Autowired
    private  NacosGatewayProperties nacosGatewayProperties;

    @Autowired
    private DynamicRouteServiceImpl dynamicRouteService;

    @Bean
    public  String init(){
        dynamicRouteByNacosListener(nacosGatewayProperties.getDataId(),
                nacosGatewayProperties.getGroupId());
        return "";
    }

    /**
     * 监听Nacos Server下发的动态路由配置
     * @param dataId
     * @param group
     */
    public void dynamicRouteByNacosListener(String dataId, String group){
        try {
            ConfigService configService= NacosFactory.createConfigService(nacosGatewayProperties.getAddress());
            String content = configService.getConfig(dataId, group, nacosGatewayProperties.getTimeout());
            System.out.println(content);

            //启动时更新一次
            List<RouteDefinition> definition= JSON.parseArray(content,RouteDefinition.class);
            definition.forEach(def->{
                dynamicRouteService.update(def);
            });

            configService.addListener(dataId, group, new Listener()  {
                @Override
                public void receiveConfigInfo(String configInfo){
                    try {
                        List<RouteDefinition> definition= JSON.parseArray(configInfo,RouteDefinition.class);
                        definition.forEach(def->{
                            dynamicRouteService.update(def);
                        });
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                @Override
                public Executor getExecutor(){
                    return null;
                }
            });
        } catch (NacosException e) {
            //todo 提醒:异常自行处理此处省略
            System.err.printf("DynamicRouteServiceImplByNacos " + e);
        }
    }
}