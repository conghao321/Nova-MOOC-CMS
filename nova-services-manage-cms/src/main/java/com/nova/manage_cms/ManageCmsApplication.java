package com.nova.manage_cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author haocong
 * @version 1.0
 * @create 2020-6-2
 **/

@EnableDiscoveryClient
@SpringBootApplication
@EntityScan("com.nova.framework.domain.cms")//扫描实体类
@ComponentScan(basePackages={"com.nova.api"})//扫描接口
@ComponentScan(basePackages={"com.nova.framework"})//扫描common包下的类
@ComponentScan(basePackages={"com.nova.manage_cms"})//扫描本项目下的所有类
public class ManageCmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageCmsApplication.class,args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }

}

