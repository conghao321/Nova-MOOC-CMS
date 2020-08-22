package com.nova.learning;
/*
 * @Author:conghao
 * @description:
 */

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

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EntityScan("com.nova.framework.domain.learning")
@ComponentScan(basePackages = {"com.nova.api"})
@ComponentScan(basePackages = {"com.nova.learning"})
@ComponentScan(basePackages = {"com.nova.framework"})
public class LearningApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(LearningApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
}