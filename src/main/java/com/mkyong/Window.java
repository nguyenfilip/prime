package com.mkyong;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.lifecycle.ClientWindow;

/**
 * Created by maslo on 30.1.17.
 */
@ManagedBean(name="window")
@RequestScoped
public class Window {

    public String getId() {
        ClientWindow win =  FacesContext.getCurrentInstance().getExternalContext().getClientWindow();

        System.out.println("Window: "+ win);
        if (win == null) {
            return "NULL TO JE";
        }
        return win.getId();
    }
}
