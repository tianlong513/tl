package com.tl.service.impl;

import com.tl.entity.SysUser;
import com.tl.mapper.UserInfoMapper;
import com.tl.service.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * @program: tl
 * @description:
 * @author:
 * @create: 2018-11-19 18:07
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public Object queryUserInfo(String username, String password) {
        Map map = new HashMap();
        SysUser userInfos = userInfoMapper.queryUserInfo(username);
        if (userInfos == null) {
            map.put("message", "用户不存在");
        } else if (!userInfos.getPassword().equals(password)) {
            map.put("message", "密码不正确");
        } else {
            map.put("message", "success");
            map.put("data", userInfos);
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            System.out.println(token.getPassword());
            subject.login(token);
        }
        return map;
    }

}
