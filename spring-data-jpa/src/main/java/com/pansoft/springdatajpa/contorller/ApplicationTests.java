package com.pansoft.springdatajpa.contorller;

import com.pansoft.springdatajpa.mapper.UserRepository;
import com.pansoft.springdatajpa.model.User;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Aspect
@Slf4j
@RestController
public class ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/save")
    public void test(){

        // 创建10条记录
        userRepository.save(new User("AAA", 10, "qwe", 2));
        userRepository.save(new User("BBB", 20, "qwe", 2));
        userRepository.save(new User("CCC", 30, "qwe", 2));
        userRepository.save(new User("DDD", 40, "qwe", 2));
        userRepository.save(new User("EEE", 50, "qwe", 2));
        userRepository.save(new User("FFF", 60, "qwe", 2));
        userRepository.save(new User("GGG", 70, "qwe", 2));
        userRepository.save(new User("HHH", 80, "qwe", 2));
        userRepository.save(new User("III", 90, "qwe", 2));
        userRepository.save(new User("JJJ", 100, "qwe", 2));

        // 测试findAll, 查询所有记录
      //  Assert.assertEquals(10, userRepository.findAll().size());

        // 测试findByName, 查询姓名为FFF的User
      //  Assert.assertEquals(60, userRepository.findByName("FFF").getAge().longValue());

        // 测试findUser, 查询姓名为FFF的User
       // Assert.assertEquals(60, userRepository.findUser("FFF").getAge().longValue());

        // 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
        //Assert.assertEquals("FFF", userRepository.findByNameAndAge("FFF", 60).getName());

        // 测试删除姓名为AAA的User
       // userRepository.delete(userRepository.findByName("AAA"));

        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
     //  Assert.assertEquals(9, userRepository.findAll().size());

    }
    @CachePut(value = "user", key = "#user.id")
    @GetMapping("/findByName")
    public int findByName(String name){
        User u1 = userRepository.findByName(name);
        log.info("第一次查询：" + u1.getAge());
        User u2 = userRepository.findByName(name);
        log.info("第二次查询：" + u2.getAge());
        return  u1.getAge() +  u2.getAge();
    }
    @RequestMapping(value = "queryMaterialType", method = RequestMethod.POST)
    public Object test1(){
        log.info("--------------->>打印日志");
        return "hellow world";
    }
    //@RestController,返回json数据
    //@Controller，返回login.jsp页面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response){
        return "login";
    }
    //无论是@RestController还是@Controller都不影响返回页面
    @RequestMapping(value = "/qwe", method = RequestMethod.GET)
    public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response){
        User user = new User();
        ModelAndView mv=new ModelAndView();
        mv.setViewName("index");
        mv.addObject("name", "liyafei");
        user.setAge(20);
        user.setName("wangwu");
        mv.addObject("user", user);

        return mv;
    }


}