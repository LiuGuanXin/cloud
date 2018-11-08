package com.pansoft.userservice2.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "gateway-zuul")
public interface XwebFeignCilent {
    @RequestMapping(value = "/xweb/businessmodel/des/encrypt/1111", method = RequestMethod.POST)
    public String getMD5();
}
