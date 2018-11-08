package com.pansoft.accountproviderservice.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController
public class Test {
    private Config apolloConfig = ConfigService.getAppConfig();
    @Value("${from}")
    private String from;
    @GetMapping("/from")
    public String from() {
        return this.from;
    }

//    @GetMapping("/getSpan")
//    public Span getSpan() {
//        return SendTracer.createSpanRelation("qqq","GET","http://111");
//    }
}
