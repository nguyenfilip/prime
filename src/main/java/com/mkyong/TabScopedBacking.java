package com.mkyong;

import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;

/**
 * Created by maslo on 30.1.17.
 */
@ManagedBean(name = "tab")
@CustomScoped("#{tab_scope}")
public class TabScopedBacking {

    private int counter = 0;

    public String getCounter() {
        return "" + counter++;
    }
}
