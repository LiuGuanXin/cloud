package com.pansoft.accountproviderservice1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class Test {
//    @Value("${from}")
//    private String from;
//    @GetMapping("/from")
//    public String from() {
//        return this.from;
//    }
}
