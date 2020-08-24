package com.nova.govern.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Hao Cong
 * @version 1.0
 * @create 2020
 *
 * GateWay service!
 **/
@SpringBootApplication
@EnableZuulProxy//此工程是一个zuul网关
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
