package com.pansoft.userservice2.feign;

import com.pansoft.userservice2.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "gateway-zuul")
public interface UserFeignClient {
    @RequestMapping(value = "/provider-service/find", method = RequestMethod.GET)
    public List<User> findAll();
    @RequestMapping(value = "/provider-service/check", method = RequestMethod.GET)
    public User checkAccount(User user);
}
