package com.pansoft.oauth2client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuweifeng wrote on 2017/10/18.
 */
@RestController
public class PublicController {

    @RequestMapping("/abc")
    public String index() {
        return "Hello abc";
    }
}