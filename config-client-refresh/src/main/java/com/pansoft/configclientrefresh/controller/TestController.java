package com.pansoft.configclientrefresh.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController
public class TestController {
    @Value("${profile}")
    private String profile;
    @GetMapping("/profile")
    public String hello(){
        return profile;
    }
}
