package com.tl.entity;


import java.util.List;

public class SysUser {

    private String id;
    private String username;
    private String password;
    private String nickName;
    private String sex;
    private java.sql.Timestamp createTime;
    private boolean emailType;

    private List<SysUserRole> sysUserRoles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public java.sql.Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.sql.Timestamp createTime) {
        this.createTime = createTime;
    }

    public List<SysUserRole> getSysUserRoles() {
        return sysUserRoles;
    }

    public void setSysUserRoles(List<SysUserRole> sysUserRoles) {
        this.sysUserRoles = sysUserRoles;
    }

    public boolean isEmailType() {
        return emailType;
    }

    public void setEmailType(boolean emailType) {
        this.emailType = emailType;
    }
}
