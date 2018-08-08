package com.pansoft.userservice.feign;

import com.pansoft.userservice.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "provider-service")
public interface UserFeignClient {
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public List<User> findAll();
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public User checkAccount(User user);
}
