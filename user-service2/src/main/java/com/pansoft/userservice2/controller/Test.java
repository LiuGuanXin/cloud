package com.pansoft.userservice2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Service;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class Test {
    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/description")
    public void getServices(){
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        Map<String, String> map = serviceInstance.getMetadata();
        log.info(map.toString());
        List list = discoveryClient.getInstances("user-service");
        log.info(list.toString());
        log.info(discoveryClient.description());
    }
}
