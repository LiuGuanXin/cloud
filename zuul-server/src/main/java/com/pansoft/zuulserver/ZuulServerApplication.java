package com.pansoft.zuulserver;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableApolloConfig
@SpringBootApplication
@EnableZuulProxy
public class ZuulServerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        System.setProperty("jasypt.encryptor.password", "klklklklklklklkl");
        SpringApplication.run(ZuulServerApplication.class, args);
    }

    @Value("${test.input}")
    private String input;

    @Value("${test.input1}")
    private String input1;

    @Override
    public void run(String... args) throws Exception {
        System.err.println("test.input 值 ENC(Ore69lUopDHL5R8Bw/G3bQ==) 解密后:" + input);
        System.err.println("test.input1 不需要解密:" + input1);
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
