package com.nova.test.freemarker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author haocong
 * @version 1.0
 * @create 2020-06-12 18:42
 * @description: freemarker test application
 **/
@SpringBootApplication
public class FreemarkerTestApplication {
    public static void main(String[] args) {

        SpringApplication.run(FreemarkerTestApplication.class,args);
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
}