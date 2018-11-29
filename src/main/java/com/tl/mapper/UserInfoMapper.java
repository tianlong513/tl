package com.tl.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tl.entity.SysUser;
import com.tl.entity.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tl
 * @description:
 * @author:
 * @create: 2018-11-19 18:02
 **/
public interface UserInfoMapper extends BaseMapper<SysUser> {
    public SysUser queryUserInfo(@Param("username") String username);

    public List<SysUserRole> queryUserRole(@Param("username") String username);

    public SysUser findByEmailType();
}