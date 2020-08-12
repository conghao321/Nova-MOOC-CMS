package com.nova.manage_course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 * @version 1.0
 **/
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EntityScan("com.nova.framework.domain.course")//扫描实体类
@ComponentScan(basePackages={"com.nova.api"})//扫描接口
@ComponentScan(basePackages={"com.nova.manage_course"})
@ComponentScan(basePackages={"com.nova.framework"})//扫描common下的所有类
public class ManageCourseApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ManageCourseApplication.class, args);
    }


    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }

}
