package com.pansoft.accountproviderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AccountProviderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountProviderServiceApplication.class, args);
    }
}
