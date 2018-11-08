package com.pansoft.accountproviderservice;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;

@EnableApolloConfig
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class AccountProviderServiceApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(AccountProviderServiceApplication.class, args);
    }
}
