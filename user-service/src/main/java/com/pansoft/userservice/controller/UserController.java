package com.pansoft.userservice.controller;

import com.pansoft.userservice.feign.UserFeignClient;
import com.pansoft.userservice.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public List<User> findAll(){
        List<User> list = userFeignClient.findAll();
        return list;
    }
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public User checkAccount(User user){
        return userFeignClient.checkAccount(user);
    }
}
