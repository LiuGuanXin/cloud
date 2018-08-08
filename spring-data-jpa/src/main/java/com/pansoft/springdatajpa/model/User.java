package com.pansoft.springdatajpa.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private double balance;

    public User() {
    }

    public User(String name, Integer age, String username, double balance) {
        this.name = name;
        this.age = age;
        this.username = username;
        this.balance = balance;
    }
}