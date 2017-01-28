package com.mkyong;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * Created by maslo on 28.1.17.
 */
@ManagedBean(name = "login")
@RequestScoped
public class Login {
    private String password;
    private String username;
    private Boolean error = false;

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    @ManagedProperty("#{user}")
    private UserDetails userDetails;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String login() {
        if ("pass".equals(password)) {
            userDetails.setUsername(username);
        } else
            error = true;
        return null;
    }
}

