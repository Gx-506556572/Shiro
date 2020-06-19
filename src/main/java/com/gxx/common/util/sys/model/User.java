package com.gxx.common.util.sys.model;

public class User {
    private String username;
    private String password;
    private Integer status;//用户状态 0 正常 1 禁用 2 锁定

    public User(String username, String password, Integer status) {
        this.username = username;
        this.password = password;
        this.status = status;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
