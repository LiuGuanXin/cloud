package com.pansoft.zipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

@SpringBootApplication
@EnableZipkinStreamServer
//@EnableEurekaClient
public class ZipkinServerApplication {

    public static void main(String[] args) {
        System.setProperty("zipkin.storage.StorageComponent","elasticsearch");
        System.setProperty("zipkin.storage.type","elasticsearch");
        SpringApplication.run(ZipkinServerApplication.class, args);
    }
}
