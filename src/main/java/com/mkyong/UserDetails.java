package com.mkyong;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Created by maslo on 28.1.17.
 */
@ManagedBean(name = "user")
@SessionScoped
public class UserDetails {
    private String username = null;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        username = null;
        return null;
    }

    public boolean getLoggedIn() {
        return username != null;
    }
}
