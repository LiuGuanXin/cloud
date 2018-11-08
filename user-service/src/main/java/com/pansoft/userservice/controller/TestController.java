package com.pansoft.userservice.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.pansoft.userservice.model.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@RestController
public class TestController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestController.class);

    @ApolloConfig
    private Config config;


    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/find1", method = RequestMethod.GET)
    public List<User> findAll1(){
        List<User> list = restTemplate.getForObject("http://localhost:8089/provider/find",List.class);
        return list;
    }





//    @Value("${test.input}")
//    String input;
    @GetMapping("/input")
    public String find(){
        Set<String> set = config.getPropertyNames();
        String input = config.getProperty("test.input","qq");
        logger.info(set.toString());
        logger.info(input);
        return "luff";
    }


}
