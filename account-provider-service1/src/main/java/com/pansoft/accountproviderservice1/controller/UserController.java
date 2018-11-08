package com.pansoft.accountproviderservice1.controller;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.pansoft.accountproviderservice1.mapper.UserMapper;
//import com.pansoft.accountproviderservice1.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @GetMapping("/find")
    public String findAll(){
        return "SUCCESS";
    }
//    @Autowired
//    private UserMapper userMapper;
//    @HystrixCommand( fallbackMethod = "findUserFallback" )
//    @GetMapping("/find")
//    public List<User> findAll(){
//        return userMapper.findAll();
//    }
//    @HystrixCommand( fallbackMethod = "findUserFallback" )
//    @GetMapping("/check")
//    public User checkAccount(User user){
//        return userMapper.checkAccount(user);
//    }
//    public List<User> findUserFallback(){
//        return null;
//    }
//    public User findUserFallback(User user){
//        user.setId(-1);
//        return user;
//    }

}
