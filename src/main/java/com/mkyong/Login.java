package com.mkyong;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Created by maslo on 28.1.17.
 */
@ManagedBean(name = "login")
@RequestScoped
public class Login {
    private String password;
    private String username;

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
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
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login error", "Please provide correct login and password"));
        }
        return null;
    }
}

