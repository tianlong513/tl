package com.tl.controller;

import com.tl.entity.SysUser;
import com.tl.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: tl
 * @description:
 * @author:
 * @create: 2018-11-19 18:08
 **/
@RestController
@RequestMapping(value = "sys")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value = "login")
    public Object userInfo(String username, String password) {
        return userInfoService.queryUserInfo(username, password);
    }

    @RequestMapping(value = "findByEmailType")
    public Object findByEmailType(String name) {
        System.out.println("请求消息"+name);
        Map result = new HashMap();
       /* Scanner scanner = new Scanner(System.in);
        String sc = scanner.next();*/

        result.put("result",name);
        return result;
    }
}
