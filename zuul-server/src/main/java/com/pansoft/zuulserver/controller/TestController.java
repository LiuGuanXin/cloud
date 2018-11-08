package com.pansoft.zuulserver.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@RestController
public class TestController {
    @ApolloConfig
    private Config config;
    @Autowired
    private RestTemplate restTemplate;
//    @Value("${test.input}")
//    String input;
    @GetMapping("/find")
    public String find(){
        Set<String> set = config.getPropertyNames();
        return "luff";
    }
    @GetMapping("/fmis")
    public String fmis(){
        restTemplate.getForObject("http://localhost:8080/EnterpriseServer/EAIServer/",String.class);
        return "QQQ";
    }
}
