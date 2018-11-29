package com.tl.config;

import com.tl.entity.SysUserRole;
import com.tl.mapper.UserInfoMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: spingboot_shiro
 * @description:
 * @author:
 * @create: 2018-10-15 09:58
 **/
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    UserInfoMapper userInfoMapper;

    /**
     * 用户登录验证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("身份验证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String token1 = (String) authenticationToken.getPrincipal();
        return new SimpleAuthenticationInfo(token.getPrincipal(), token.getPassword(), getName());
    }

    /**
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("鉴权");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> set = new HashSet<>();
        List<SysUserRole> userRoles = userInfoMapper.queryUserRole(username);

        for (SysUserRole r : userRoles) {
            set.add(r.getRname());
        }
        info.setRoles(set);
        return info;
    }

}