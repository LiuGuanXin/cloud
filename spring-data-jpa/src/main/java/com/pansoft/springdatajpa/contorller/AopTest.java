package com.pansoft.springdatajpa.contorller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Slf4j
public class AopTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(AopTest.class);
    public static void main(String[] args){
        new AopTest().say();
    }


    public void say(){
        LOGGER.info("hhhhhhhhhhhhhh");
        log.info("qqqqqqqqqqqqqqqqqqqqqqqqqqq");
    }

}
