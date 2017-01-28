package com.mkyong;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by maslo on 27.1.17.
 */
@ManagedBean(name = "cart")
@ApplicationScoped
public class CartBean {
    private int counter = 0;
    public int getCounter() {
        return counter++;
    }
}
