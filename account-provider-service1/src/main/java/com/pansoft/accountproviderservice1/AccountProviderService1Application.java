package com.pansoft.accountproviderservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//import org.springframework.retry.annotation.CircuitBreaker;

@SpringBootApplication
//@EnableCircuitBreaker
public class AccountProviderService1Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AccountProviderService1Application.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AccountProviderService1Application.class);
    }
}
