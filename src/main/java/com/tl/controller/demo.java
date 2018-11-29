package com.tl.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: tl
 * @description:
 * @author:
 * @create: 2018-11-19 17:12
 **/
@RestController
public class demo {
    @RequestMapping(value = "test1")
    @RequiresRoles({"admin","update"})
    public String test12() {
        return "12345";
    }

}
