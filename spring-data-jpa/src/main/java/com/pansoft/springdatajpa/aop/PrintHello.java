package com.pansoft.springdatajpa.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class PrintHello {
    @Pointcut("execution(* com.pansoft.springdatajpa.contorller.AopTest.say())")
    public void webLog(){}
    @Before(value = " webLog()")
    public void before(){
        log.info("开始插入数据");
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("方法的返回值 : " + ret);
    }
    //后置异常通知
    @AfterThrowing("webLog()")
    public void throwss(JoinPoint jp){
        log.info("方法异常时执行.....");
    }

    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
    @After("webLog()")
    public void after(JoinPoint jp){
        log.info("方法最后执行.....");
    }
}
