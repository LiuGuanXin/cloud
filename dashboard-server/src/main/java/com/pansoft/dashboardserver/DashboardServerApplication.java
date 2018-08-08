package com.pansoft.dashboardserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class DashboardServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DashboardServerApplication.class, args);
    }
}
