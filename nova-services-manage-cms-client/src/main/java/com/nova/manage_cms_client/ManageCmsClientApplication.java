package com.nova.manage_cms_client;
/*
 * @Author:conghao
 * @description:
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.nova.framework.domain.cms")
@ComponentScan(basePackages={"com.nova.framework"})//扫描common包下的类
@ComponentScan(basePackages={"com.nova.manage_cms_client"})//扫描本项目下的所有类
public class ManageCmsClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageCmsClientApplication.class, args);

    }
}
