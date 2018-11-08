package com.pansoft.accountproviderservice.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.AbstractBeanFactory;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Data
@Slf4j
@Component
public class User {
    private Integer id;
    private String username;
    private String name;
    private Integer age;
    private BigDecimal balance;

}