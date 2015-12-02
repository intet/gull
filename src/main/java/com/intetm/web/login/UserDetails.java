package com.intetm.web.login;

import com.intetm.db.entity.Authority;
import com.intetm.db.entity.User;

import java.util.List;

class UserDetails {
    private String userName;
    private List<Authority> authorities;

    public UserDetails(User user) {
        this.userName = user.getUserName();
        this.authorities = user.getAuthorities();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}
