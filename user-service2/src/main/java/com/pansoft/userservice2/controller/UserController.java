package com.pansoft.userservice2.controller;

import com.pansoft.userservice2.feign.UserFeignClient;
import com.pansoft.userservice2.feign.XwebFeignCilent;
import com.pansoft.userservice2.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Slf4j
@RestController
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private XwebFeignCilent xwebFeignCilent;

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public List<User> findAll(){
        List<User> list = userFeignClient.findAll();
        return list;
    }
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public User checkAccount(User user){
        return userFeignClient.checkAccount(user);
    }

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public ResponseEntity<String> hello() {
        LOGGER.info("called by product-service");
        return new ResponseEntity<>("hello product service!", HttpStatus.OK);
    }

    @RequestMapping(value = "/getMD5", method = RequestMethod.POST)
    public String getMD5(){
        return xwebFeignCilent.getMD5();
    }
}
